package com.gamalinda.java.jdialog;

import com.gamalinda.java.jframe.Feature;

import javax.swing.*;
import java.awt.*;

public class ShowDialogFeature implements Feature {

    private Frame parentFrame;

    public ShowDialogFeature(Frame frame) {
        parentFrame = frame;
    }

    @Override
    public void execute() {
        showDialog();
    }

    private void showDialog() {
        JOptionPane.showMessageDialog(parentFrame, "Hello World");
    }
}
