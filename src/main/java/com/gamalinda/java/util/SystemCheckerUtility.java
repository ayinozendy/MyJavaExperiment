package com.gamalinda.java.util;

public class SystemCheckerUtility {
    //https://developer.apple.com/library/mac/#technotes/tn2002/tn2110.html
    public static boolean isOSX() {
        String osName = System.getProperty("os.name");
        return osName.contains("OS X");
    }

    //https://developer.apple.com/library/mac/#technotes/tn2002/tn2110.html
    public static boolean isSnowLeopardOrBetter() {
        String osName = System.getProperty("os.name");
        if (!osName.contains("OS X")) return false;

        // split the "10.x.y" version number
        String osVersion = System.getProperty("os.version");
        String[] fragments = osVersion.split("\\.");

        // sanity check the "10." part of the version
        if (!fragments[0].equals("10")) return false;
        if (fragments.length < 2) return false;

        // check if OS X 10.6(.y)
        try {
            int minorVers = Integer.parseInt(fragments[1]);
            if (minorVers >= 6) return true;
        } catch (NumberFormatException e) {
            // was not an integer
        }

        return false;
    }

    //https://developer.apple.com/library/mac/#technotes/tn2002/tn2110.html
    public static boolean isJava15OrBetter() {
        String javaVersion = System.getProperty("java.version");
        String[] fragments = javaVersion.split("\\.");

        // sanity check the "1." part of the version
        if (!fragments[0].equals("1")) return false;
        if (fragments.length < 2) return false;

        // check if Java 1.5.x or higher
        try {
            int minorVers = Integer.parseInt(fragments[1]);
            if (minorVers >= 5) return true;
        } catch (NumberFormatException e) {
            // was not an integer
        }

        return false;
    }
}
