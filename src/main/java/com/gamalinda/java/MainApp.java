package com.gamalinda.java;

import com.gamalinda.java.jframe.FeaturesWindow;
import com.gamalinda.java.util.Log;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    private static final String TAG = MainApp.class.getSimpleName();

    private static MainApp mainAppInstance = new MainApp();

    private static List<String> argsList;

    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 240;

    private MainApp() {
    }

    public static void main(String[] args) {

        argsList = Arrays.asList(args);
        getInstance().run();
    }

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

    private static void runAsMacApp() {
        setUiLookAndFeelAsMacApp();
    }

    private static void setUiLookAndFeelAsMacApp() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static MainApp getInstance() {
        return mainAppInstance;
    }

    private void run() {
        printHelloWorld();
        printArgs();
        respondToArgs();
        showAndRunMainFeaturesWindow();
    }

    private void printHelloWorld() {
        System.out.println("Hello World");
        Log.i(TAG, "Hello World");
    }

    private void printArgs() {
        for (String arg : argsList) {
            System.out.println(arg);
        }
    }

    private void respondToArgs() {
        for (String arg : argsList) {

            if (arg.equals("-a")) {
                System.out.println("Responding to A");
            } else if (arg.equals("-b")) {
                System.out.println("Responding to B");
            } else if (arg.equals("-c")) {
                System.out.println("Responding to C");
            } else if (arg.equals("-d")) {
                System.out.println("Responding to D");
            } else {
                System.out.println("Responding to Default");
            }
        }
    }

    private void showAndRunMainFeaturesWindow() {
        FeaturesWindow mainFeaturesWindow = FeaturesWindow.buildWindow("MyJavaExperiment", WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFeaturesWindow.showMenuBar();
        mainFeaturesWindow.showWindow();
        mainFeaturesWindow.run();
    }
}