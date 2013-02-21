package com.gamalinda.java.jframe;

import javax.swing.*;
import java.awt.*;

public class FeaturesWindow {
    private static final String TAG = FeaturesWindow.class.getSimpleName();
    private static JFrame mainFrame;

    private static double SCREEN_WIDTH;
    private static double SCREEN_HEIGHT;

    public void buildWindow(String windowTitle, int width, int height) {
        mainFrame = new JFrame(windowTitle);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(width, height);
    }

    public void showWindow() {
        mainFrame.setVisible(true);
    }

    public void run() {
        writeOnScreen();
    }

    private void writeOnScreen() {
        JWindow w = new JWindow();
        w.add(new JLabel("Hello World!"));

        getScreenDimensions();
        int centerHorizontal = (int) (SCREEN_WIDTH / 2);
        int centerVertical = (int) (SCREEN_HEIGHT / 2);

        w.setLocation(centerHorizontal, centerVertical);
        w.pack();
        w.setVisible(true);
    }

    private void getScreenDimensions() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = screenSize.getWidth();
        SCREEN_HEIGHT = screenSize.getHeight();
    }
}
