package com.gamalinda.java.jframe;

import javax.swing.*;
import java.awt.*;

public class FeaturesWindow {
    private static final String TAG = FeaturesWindow.class.getSimpleName();

    private static JFrame mainFrame;
    private static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JMenu featuresMenu;

    private static double SCREEN_WIDTH;
    private static double SCREEN_HEIGHT;

    public void buildWindow(String windowTitle, int width, int height) {
        mainFrame = new JFrame(windowTitle);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(width, height);

        showMenuBar();
    }

    private void showMenuBar() {
        menuBar = new JMenuBar(); //The Menu Bar on Windows
        fileMenu = new JMenu("File"); //The Menu Bar Menu item
        featuresMenu = new JMenu("Features");

        menuBar.add(fileMenu); //Add the menus to the menu bar
        showFileMenuItems();

        menuBar.add(featuresMenu);

        mainFrame.getContentPane().add(BorderLayout.NORTH, menuBar);
    }

    private void showFileMenuItems() {
        JMenuItem exitMenuItem = new JMenuItem("Exit"); //Menu item
        fileMenu.add(exitMenuItem); //Adding a menu item to a menu
    }

    public void showWindow() {
        mainFrame.setVisible(true);
    }

    public void run() {
        writeOnScreen();
    }

    private void writeOnScreen() {
        JWindow w = new JWindow(); //A frameless window
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
