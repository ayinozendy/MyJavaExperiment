package com.gamalinda.java.jframe;

import com.gamalinda.java.jframe.jmenubar.FeaturesWindowMenuBar;

import javax.swing.*;

public class FeaturesWindow {
    private static final String TAG = FeaturesWindow.class.getSimpleName();

    private static JFrame mainFrame;

    private static FeaturesWindowMenuBar mainMenuBar;

    private FeaturesWindow() {
    }

    public static FeaturesWindow buildWindow(String windowTitle, int width, int height) {
        FeaturesWindow featuresWindow = new FeaturesWindow();
        featuresWindow.mainFrame = new JFrame(windowTitle);
        featuresWindow.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        featuresWindow.mainFrame.setSize(width, height);

        return featuresWindow;
    }

    public void showMenuBar() {
        mainMenuBar = new FeaturesWindowMenuBar();
        mainFrame.setJMenuBar(mainMenuBar.getMenuBar());
    }

    public void showWindow() {
        mainFrame.setVisible(true);
    }

    public void run() {

    }

}
