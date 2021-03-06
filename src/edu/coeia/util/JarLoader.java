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

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

/**
 *
 * @author wajdyessam
 *
 * to download Jar files at runtime
 *
 * the format of library name: lib/swt_win_32.jar lib/swt_win_64.jar
 * lib/swt_linux_32.jar lib/swt_linux_64.jar
 *
 * the example from:
 * http://www.chrisnewland.com/select-correct-swt-jar-for-your-os-and-jvm-at-runtime-191
 */
public class JarLoader {
    private final static Logger logger = ApplicationLogging.getLogger();
    
    public static void loadSWTLibrary() {
        File swtJar = new File(getArchFilename("runtime_libs/swt")); 
        addJarToClasspath(swtJar);
    }
    
    private static void addJarToClasspath(File jarFile) {
        try {
            URL url = jarFile.toURI().toURL();
            URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Class<?> urlClass = URLClassLoader.class;
            Method method = urlClass.getDeclaredMethod("addURL", new Class<?>[]{URL.class});
            method.setAccessible(true);
            method.invoke(urlClassLoader, new Object[]{url});
            logger.info("Loading Jar File: " + jarFile.getAbsolutePath());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static String getArchFilename(String prefix) {
        return prefix + "_" + getOSName() + "_" + getArchName() + ".jar";
    }

    private static String getOSName() {
        String osNameProperty = System.getProperty("os.name");

        if (osNameProperty == null) {
            throw new RuntimeException("os.name property is not set");
        } else {
            osNameProperty = osNameProperty.toLowerCase();
        }

        if (osNameProperty.contains("win")) {
            return "win";
        } else if (osNameProperty.contains("mac")) {
            return "osx";
        } else if (osNameProperty.contains("linux") || osNameProperty.contains("nix")) {
            return "linux";
        } else {
            throw new RuntimeException("Unknown OS name: " + osNameProperty);
        }
    }

    private static String getArchName() {
        String osArch = System.getProperty("os.arch");

        if (osArch != null && osArch.contains("64")) {
            return "64";
        } else {
            return "32";
        }
    }
}
