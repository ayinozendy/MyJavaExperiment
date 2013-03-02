package com.gamalinda.java.jframe.jmenubar;

import com.gamalinda.java.jframe.Feature;
import com.gamalinda.java.jframe.ShowPictureFeature;
import com.gamalinda.java.jframe.WriteToScreenFeature;
import com.gamalinda.java.util.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FeaturesWindowMenuBar implements ActionListener {
    private static final String TAG = FeaturesWindowMenuBar.class.getSimpleName();

    private static JMenuBar menuBar;
    private static JMenu fileMenu;
    private static JMenu featuresMenu;

    //Menu
    private static final String FILE = "File";
    private static final String FEATURES = "Features";

    //Menu Item Names/Action
    private static final String EXIT = "Exit";
    private static final String WRITE_TO_SCREEN = "Write to Screen";
    private static final String SHOW_PICTURE = "Show Picture";

    //Desktop screen dimensions
    private static double SCREEN_WIDTH;
    private static double SCREEN_HEIGHT;

    public FeaturesWindowMenuBar() {
        loadMenuBar();
    }

    private void loadMenuBar() {
        menuBar = new JMenuBar(); //The Menu Bar on Windows
        fileMenu = new JMenu(FILE); //The Menu Bar Menu item
        featuresMenu = new JMenu(FEATURES);

        menuBar.add(fileMenu); //Add the menus to the menu bar
        showFileMenuItems();

        menuBar.add(featuresMenu);
        showFeaturesMenuItems();
    }

    private void showFileMenuItems() {
        JMenuItem exitMenuItem = new JMenuItem(EXIT); //Menu item
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem); //Adding a menu item to a menu
    }

    private void showFeaturesMenuItems() {
        loadWriteToScreenMenuItem();
        loadShowPictureMenuItem();
    }

    private void loadWriteToScreenMenuItem() {
        JMenuItem writeToScreenItem = new JMenuItem(WRITE_TO_SCREEN);
        writeToScreenItem.addActionListener(this);
        writeToScreenItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        featuresMenu.add(writeToScreenItem);
    }

    private void loadShowPictureMenuItem() {
        JMenuItem showPictureItem = new JMenuItem(SHOW_PICTURE);
        showPictureItem.addActionListener(this);
        showPictureItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        featuresMenu.add(showPictureItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(EXIT)) {
            Log.d(TAG, "exitApp()"); //Should log first before exit app because it won't be reached when exit
            exitApp();
        } else if (e.getActionCommand().equals(WRITE_TO_SCREEN)) {
            executeFeature(new WriteToScreenFeature());
            Log.d(TAG, "execute WriteToScreenFeature()");
        } else if (e.getActionCommand().equals(SHOW_PICTURE)) {
            executeFeature(new ShowPictureFeature());
            Log.d(TAG, "execute ShowPictureFeature()");
        }
    }

    private void exitApp() {
        System.exit(0);
    }

    private void executeFeature(Feature feature) {
        feature.execute();
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}