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
package edu.coeia.util;

/**
 *
 * @author wajdyessam
 */

import edu.coeia.util.FileUtil;
import edu.coeia.util.Utilities;
import static edu.coeia.util.PreconditionsChecker.* ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.security.MessageDigest ;
import java.security.NoSuchAlgorithmException ;
import java.security.DigestInputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MD5 Hash Calculator for files and directories
 * return the hash representation as uppercase hex string
 * @author wajdyessam
 */
public class HashCalculator {
    
    /**
     * Calculate MD5 hash for <tt>path</tt> file
     * @param path should contain valid file 
     * @return hash value for the path
     */
    public static String calculateFileHash (final String path){
        checkNull("path must be not null", path);
        checkNotEmptyString("path must be not empty", path);
        
        if ( !FileUtil.isFileFound(path) )
            throw new IllegalArgumentException("Path pointer to not valid file");
        
        return MD5HashCalculator(path);
    }

    public static String calculateStringHash(final String message) {
            StringBuilder digestString = new StringBuilder();
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            digestString.append(Utilities.toHex(md.digest()));
        }
        catch(NoSuchAlgorithmException e) {
            
        }

        return digestString.toString();
    }
    
    /**
     * Calculate Hash Value for directory
     */
    public final static class DirectoryHash {
        private final MessageDigest digest ;
        
        public static DirectoryHash newInstance() {
            try {
                return new DirectoryHash();
            }
            catch(NoSuchAlgorithmException e ) { }
            
            throw new NullPointerException("cannot make md5 algorithm");
        }
        
        private DirectoryHash() throws NoSuchAlgorithmException{
            digest = MessageDigest.getInstance("MD5");
        }
        
        public void addFile(final String path) {
            //digest.update(FileUtil.getFileBytes(path));
            DigestInputStream digestInputStream = null;
            try {
                digestInputStream = new DigestInputStream(new FileInputStream(path), digest);
                byte[] buffer = new byte[8192];
                while( digestInputStream.read(buffer) != -1 );
            } catch (Exception ex) {
                Logger.getLogger(HashCalculator.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    digestInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(HashCalculator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        public String done() {
            return (Utilities.toHex(digest.digest()));
        }
    }
    
    /**
     * get MD5 hash value for path file
     * @param path the path to the file
     * @return hex uppercase string hash value
     */
    private static String MD5HashCalculator(final String path) {
        assert path != null;
        
        StringBuilder digestString = new StringBuilder();
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //md.update(FileUtil.getFileBytes(path));
            DigestInputStream digestInputStream = new DigestInputStream(new FileInputStream(path), md);
            byte[] buffer = new byte[8192];
            while( digestInputStream.read(buffer) != -1 );
            digestString.append(Utilities.toHex(md.digest()));
            digestInputStream.close();
        }
        catch(FileNotFoundException e) {
            
        }
        catch(NoSuchAlgorithmException e) {
            
        }
        catch(IOException e) {
            
        }
        
        return digestString.toString();
    }
}
