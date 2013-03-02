package com.gamalinda.java.jwindow;

import com.gamalinda.java.util.ScreenDimensionHelper;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WriteToScreenFeature implements KeyListener {
    private static final String TAG = WriteToScreenFeature.class.getSimpleName();

    private static final int ESCAPE_KEY_CODE = 27;

    JFrame frame;

    public void execute() {
        loadFrame();
        setFrameLocation();
        showFrame();
    }

    private void loadFrame() {
        frame = new JFrame(); //A frameless window
        frame.add(new JLabel("Hello World!"));
        frame.setUndecorated(true);
        frame.addKeyListener(this);
    }

    private void setFrameLocation() {
        ScreenDimensionHelper screenDimensionHelper = new ScreenDimensionHelper();
        int centerHorizontal = (int) screenDimensionHelper.getMiddleWidth();
        int centerVertical = (int) screenDimensionHelper.getMiddleHeight();

        frame.setLocation(centerHorizontal, centerVertical);
    }

    private void showFrame() {
        frame.pack(); //Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == ESCAPE_KEY_CODE) {
            frame.dispose();
        }
    }
}
