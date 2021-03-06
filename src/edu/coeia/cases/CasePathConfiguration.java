/* 
 * Copyright (C) 2014 Center of Excellence in Information Assurance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.coeia.cases;

import edu.coeia.util.FileUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * any file in the index consist of path fields point to evidence folder
 * to handle updating the index when evidence folder change problem
 * this path fields will be relative to configuration file
 * and the configuration file will point to the full evidence folder path
 * 
 * so when changing evidence path, then we will change the configuration file
 * without updating the index, or re-indexing it again.
 * 
 * also this class can detect if the evidence folder is not exists
 * and ask for the new one, then update the configuration file
 * 
 * @author wajdyessam
 */

final class CasePathConfiguration {
    private final List<PathMapping> casePathsMapping;
    private final String configurationFileLocation ;
    
    public static final String RELATIVE_PATH_PREFIX = "@PATH_%d@";
    
    /**
     * make new case path handler and set the configuration path
     * @param caseConfigurationFilePath the path to current case
     */
    public CasePathConfiguration(final String caseConfigurationFilePath) {
        this.casePathsMapping = new ArrayList<PathMapping>();
        this.configurationFileLocation = caseConfigurationFilePath ;
    }
    
    /**
     * Adding case source file here (with the relative path)
     * the relative path will be begin by prefix then followed by number
     * to differentiate between two different case source
     * 
     * the method will adding this relative/absolute path mapping
     * in collection of mapping, but it will not save it until
     * the call to save configuration method is done
     * 
     * @param file the file we add to the case
     */
    public void add(final File file){
        String fileName = String.format(RELATIVE_PATH_PREFIX, this.casePathsMapping.size());
        PathMapping entry = new PathMapping(fileName, file.getAbsolutePath());
        this.casePathsMapping.add(entry);
    }
    
    /**
     * save the list of mapping that is hold by this object
     * into file inside case folder
     * 
     * @throws IOException 
     */
    public void saveConfiguration() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(this.configurationFileLocation), true));
        
        for(PathMapping entry: this.casePathsMapping)
            writer.println(entry.relativePath + " - " + entry.absolutePath);
        
        writer.close();
    }
    
    /**
     * Read all the configuration from the case configuration file into 
     * list of mapping
     * @return unmodifiable list of mapping file paths
     * @throws IOException 
     */
    public List<PathMapping> reloadFileMapping() throws IOException{
        this.casePathsMapping.clear();
        
        List<String> lines = FileUtil.getFileContentInList(new File(this.configurationFileLocation));
        
        for(String line: lines) {
            String name = line.split("-")[0].trim();
            String path = line.substring(line.indexOf("-") + 1).trim();
            this.casePathsMapping.add(new PathMapping(name, path));
        }
        
        return Collections.unmodifiableList(this.casePathsMapping);
    }
    
    /**
     * Convert from relative path into absolute path
     * @param relativePath the relative path for some file
     * @return the absolute path for this file
     */
    public String getFullPath(final String relativePath) {
       StringBuilder fullPath = new StringBuilder();
       
       for(int i=0; i<this.casePathsMapping.size(); i++) {
           PathMapping entry = this.casePathsMapping.get(i);
           
           if ( relativePath.startsWith(entry.relativePath) ) {
               String filePath = relativePath.split(String.format(RELATIVE_PATH_PREFIX + "\\\\", i))[1];
               fullPath.append(entry.absolutePath);
               fullPath.append(File.separator);
               fullPath.append(filePath);
               break;
           }
       }
       
       if ( fullPath.toString().isEmpty() )
           return relativePath;
       
       return fullPath.toString();
    }
    
    /**
     * Convert from the absolute path into the relative path
     * @param file the file that we want its relative path
     * @return the relative path for this file
     */
    public String getRelativePath(final String file) {
        return this.getRelativePath(new File(file));
    }
    
    /**
     * Convert from the absolute path into the relative path
     * @param file the file that we want its relative path
     * @return the relative path for this file
     */
    public String getRelativePath(final File file) {
        String fullPath = file.getAbsolutePath();
        StringBuilder relativePath = new StringBuilder();
        
        for(int i=0; i<this.casePathsMapping.size(); i++) {
            PathMapping entry = this.casePathsMapping.get(i);
            
            if ( fullPath.contains(entry.absolutePath)) {
                relativePath.append(String.format(RELATIVE_PATH_PREFIX, i));
                relativePath.append(File.separator);
                relativePath.append(getRemainingPath(fullPath, entry.absolutePath));
                break;
            }
        }
        
        return relativePath.toString();
    }
    
    private String getRemainingPath(final String fullPath, final String partPath) {
        StringBuilder buffer = new StringBuilder();
        
        String tmp = fullPath.replace(partPath, "");
        
        if ( tmp.startsWith("\\") ) {
            buffer.append(tmp.substring(1));
        }
        else {
            buffer.append(tmp);
        }
        
        return buffer.toString();
    }
    
    /**
     * replace entry that have the same relative path as the entry passed to method
     * @param entry the new entry we want its absolute path
     * @throws IOException 
     */
    public void updateFullPath(final PathMapping entry) throws IOException {
        List<String> lines = FileUtil.getFileContentInList(new File(this.configurationFileLocation));
        List<String> newLines = new ArrayList<String>();
        
        // fill with unmodifiable entry
        for(String line: lines) {
            String name = line.split("-")[0].trim();
            
            if ( name.equals(entry.relativePath)) 
                continue;
            
            newLines.add(line);
        }
        
        //add the new one
        String line = entry.relativePath + " - " + entry.absolutePath;
        newLines.add(line);
        
        FileUtil.writeToFile(newLines, this.configurationFileLocation);
    }
        
    /**
     * detect and return all the entry that have missing absolute path
     * @return list of not founded entries in configuration file
     */
    public List<PathMapping> getChangedEntries() throws IOException {
        this.reloadFileMapping();
        
        List<PathMapping> changedEntries = new ArrayList<PathMapping>();
        
        for(PathMapping entry: this.casePathsMapping) {
            if ( this.isSourceChanged(entry) ) {
                changedEntries.add(entry);
            }
        }
        
        return changedEntries;
    }
    
    /**
     * Simple class represent the mapping of full and relative path
     * in the configuration file
     */
    public static class PathMapping {
        String relativePath, absolutePath;
        
        public PathMapping(final String name, final String path) {
            this.relativePath = name;
            this.absolutePath = path;
        }
    }
    
    /**
     * detect of their is any changed on absolute path in the entry
     * @param entry that we want to check if its changed or not
     * @return 
     */
    private boolean isSourceChanged(final PathMapping entry) {
        boolean isChanged = false;
        
        String path = entry.absolutePath;
        File file = new File(path);

        if ( !file.exists()) {
            isChanged = true;
        }
        
        return isChanged;
    }
}
