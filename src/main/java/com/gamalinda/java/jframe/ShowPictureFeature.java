package com.gamalinda.java.jframe;

import com.gamalinda.java.util.ScreenDimensionHelper;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShowPictureFeature implements KeyListener {
    private static final String TAG = ShowPictureFeature.class.getSimpleName();

    JFrame frame;

    public void execute() {
        loadFrame();
        addImageToFrame();
        setFrameLocation();
        showFrame();
    }

    private void loadFrame() {
        frame = new JFrame();
        frame.addKeyListener(this);
    }

    private void addImageToFrame() {
        String imageResourcePath = "/images/opensource-logo.png";
        ImageIcon image = new ImageIcon(ShowPictureFeature.class.getResource(imageResourcePath));
        JLabel imageLabel = new JLabel(image);

        int imageIconWidth = image.getIconWidth();
        int imageIconHeight = image.getIconHeight();

        imageLabel.setSize(imageIconWidth, imageIconHeight);
        frame.add(imageLabel);
        frame.pack();
    }

    private void setFrameLocation() {
        new ScreenDimensionHelper().setWindowLocationToCenter(frame);
    }

    private void showFrame() {
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            frame.dispose();
        }
    }
}
