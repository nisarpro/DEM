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

public class FirefoxDetector implements AutoDetection{
 
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
                        String outlookFolderPath = userFile.getAbsolutePath() + "\\Application Data\\Mozilla\\Firefox\\Profiles";

                        File outlookFolderFile = new File(outlookFolderPath);
                        if (outlookFolderFile.exists()) {
                            File[] outlookFiles = outlookFolderFile.listFiles();

                            for (File outlookFile : outlookFiles) {
                                if (outlookFile.isDirectory()) {
                                    String outlookFilePath = outlookFile.getAbsolutePath();
                                    resultPath.add(outlookFilePath);
                                }
                            }
                        }
                    }
                }
            }
        } else { //C:\Users\Wajdy Essam\AppData\Roaming\Mozilla\Firefox\Profiles\9bh2w0j2.default
            for (String s : path) {
                String filePath = s + "\\" + "Users";
                File osFile = new File(filePath);

                if (osFile.exists()) {
                    File[] files = osFile.listFiles();

                    for (File userFile : files) {
                        String ieFolderPath = userFile.getAbsolutePath() + "\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles";

                        File ieFolderFile = new File(ieFolderPath);
                        if (ieFolderFile.exists()) {
                            File[] outlookFiles = ieFolderFile.listFiles();

                            for (File outlookFile : outlookFiles) {
                                if (outlookFile.isDirectory()) {
                                    String outlookFilePath = outlookFile.getAbsolutePath();
                                    resultPath.add(outlookFilePath);
                                }
                            }
                        }
                    }
                }
            }
        }
 
        return resultPath;
    }
}
