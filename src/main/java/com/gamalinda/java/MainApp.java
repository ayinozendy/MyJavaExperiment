package com.gamalinda.java;

import com.gamalinda.java.jframe.FeaturesWindow;
import com.gamalinda.java.util.Log;

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