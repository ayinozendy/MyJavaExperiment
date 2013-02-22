package com.gamalinda.java;

import com.gamalinda.java.jframe.FeaturesWindow;
import com.gamalinda.java.util.Log;
import com.gamalinda.java.util.SystemCheckerUtility;

import javax.swing.*;
import java.awt.*;
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
        runAsMacAppIfOSX();
        argsList = Arrays.asList(args);
        getInstance().run();
    }

    private static void runAsMacAppIfOSX() {
        if (SystemCheckerUtility.isOSX()) {
            Log.i(TAG, "OS X detected, applying OS X look and feel");
            runAsMacApp();
        }
    }

    private static void runAsMacApp() {
        /*
        The Menubar and Application Name can be set using plist, uncomment these methods
        if you want to test using the jar only.
        */
        //moveMenuBarToMacMenuBar();
        //changeMacMenuBarApplicationName();
        setUiLookAndFeelAsMacApp();
    }

    private static void moveMenuBarToMacMenuBar() {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
    }

    private static void changeMacMenuBarApplicationName() {
        System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Java Experiment");
    }

    private static void setUiLookAndFeelAsMacApp() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            Log.e(TAG, e.toString());
        } catch (InstantiationException e) {
            Log.e(TAG, e.toString());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.toString());
        } catch (UnsupportedLookAndFeelException e) {
            Log.e(TAG, e.toString());
        }
    }

    public static MainApp getInstance() {
        return mainAppInstance;
    }

    private void run() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                respondToArgs();
                printArgs();
                showAndRunMainFeaturesWindow();
            }
        });
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
        FeaturesWindow mainFeaturesWindow = FeaturesWindow.buildWindow("The Java Experiment", WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFeaturesWindow.showMenuBar();
        mainFeaturesWindow.showWindow();
        mainFeaturesWindow.run();
    }
}