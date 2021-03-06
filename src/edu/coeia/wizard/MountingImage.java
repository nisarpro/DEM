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
package edu.coeia.wizard;

import edu.coeia.constants.ApplicationConstants;
import edu.coeia.util.FileUtil;

import java.util.List;

/**
 * Mount Image (iso, encase and some other binary images type)
 * by calling OFSmount command line tool to do the mounting operation
 * 
 * @author wajdyessam
 */

public class MountingImage {
    private final String fileName;

    public MountingImage(final String fileName) { 
        this.fileName = fileName;
    }

    /**
     * mounting the image in drive ( the new of the drive will be the next available one)
     * 
     * @return the path of new drive that contain the files inside the image
     * @throws Exception if there is some error in mounting the image file
     */
    public String mount() throws Exception{
        String applicationParameter = String.format(ApplicationConstants.mountLuncher, this.fileName);
        List<String> output = FileUtil.readProgramOutputStream(applicationParameter);

        if ( haveError(output) ) 
            throw new Exception("Cannot mount this image file: " + this.fileName);

        return getDriveLetter(output);
    }

    /**
     * Check to see if the output have error then throws exception
     * to the user know about this problem
     */
    private boolean haveError(final List<String> result) throws Exception{
        for(String line: result) {
            if ( line.contains("Done.") ) {
                return false;
            }
        }

        return true;
    }

    /**
     * get the new drive letter from the result
     * because its auto generated and we don't know the name of the 
     * new generated drive, so you parsing until find the letter
     *
     * the format of the line that contain the drive letter is:
     * 				Created device 0: G: -> XPHash.E01
     * in the above example the drive letter is G:\\
     */
    private String getDriveLetter(final List<String> result) {
        for(String line: result) {
            if ( line.contains("Created device")) {
                String letter = line.split(":")[1];
                String fullDrivePath = letter + ":\\";	// letter + : + \
                return fullDrivePath.trim();
            }
        }

        return "";
    }
}
