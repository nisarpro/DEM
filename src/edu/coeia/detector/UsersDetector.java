/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.coeia.detector;

import edu.coeia.constants.OpreatingSystemConstants;

import java.util.List;
import java.util.ArrayList ;

import java.io.File ;

/**
 *
 * @author wajdyessam
 */
public class UsersDetector implements AutoDetection {
   
    @Override
    public List<String> getFilesInPathInternet (List<String> path) {
        List<String> resultPath = new ArrayList<String>();
         File[] roots = File.listRoots();

        if (OpreatingSystemConstants.getOSType() == OpreatingSystemConstants.OS_TYPE.XP) {
            for (String s : path) {
                String filePath = s + "\\" + "Documents and Settings";
                File osFile = new File(filePath);

                if (osFile.exists()) {
                    File[] files = osFile.listFiles();

                    for (File userFile : files) {
                        if (!userFile.isHidden() && userFile.canRead()) {
                            resultPath.add(userFile.getAbsolutePath());
                        }
                    }
                }
            }
        } else {
            for (String s : path) {
                String filePath = s + "\\" + "Users";
                File osFile = new File(filePath);

                if (osFile.exists()) {
                    File[] files = osFile.listFiles();

                    for (File userFile : files) {
                        if (!userFile.isHidden() && userFile.canRead()) {
                            resultPath.add(userFile.getAbsolutePath());
                        }
                    }
                }
            }
        }

        return resultPath;
    }
}
