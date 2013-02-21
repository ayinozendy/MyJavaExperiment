package com.gamalinda.java.jframe;

import javax.swing.*;

public class FeaturesWindow {
    private static final String TAG = FeaturesWindow.class.getSimpleName();
    private static JFrame mainFrame;

    public void buildWindow(String windowTitle, int width, int height) {
        mainFrame = new JFrame(windowTitle);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(width, height);
    }

    public void showWindow() {
        mainFrame.setVisible(true);
    }
}
