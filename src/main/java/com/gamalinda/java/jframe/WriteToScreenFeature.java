package com.gamalinda.java.jframe;

import com.gamalinda.java.util.ScreenDimensionHelper;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WriteToScreenFeature implements Feature, KeyListener {
    private static final String TAG = WriteToScreenFeature.class.getSimpleName();

    private JFrame frame;

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
        new ScreenDimensionHelper().setWindowLocationToCenter(frame);
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            frame.dispose();
        }
    }
}
