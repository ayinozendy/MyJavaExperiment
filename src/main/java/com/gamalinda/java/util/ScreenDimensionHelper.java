package com.gamalinda.java.util;

import java.awt.*;

public class ScreenDimensionHelper {

    //Desktop screen dimensions
    private static double SCREEN_WIDTH;
    private static double SCREEN_HEIGHT;

    private static Dimension screenSize;

    public ScreenDimensionHelper() {
        loadScreenDimensions();
    }

    private void loadScreenDimensions() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = screenSize.getWidth();
        SCREEN_HEIGHT = screenSize.getHeight();
    }

    private Dimension getScreenDimensions() {
        return screenSize;
    }

    public double getScreenWidth() {
        return SCREEN_WIDTH;
    }

    public double getScreenHeight() {
        return SCREEN_HEIGHT;
    }

    public Dimension getScreenCenterPosition() {
        return new Dimension((int) (SCREEN_WIDTH / 2), (int) (SCREEN_HEIGHT / 2));
    }

    public double getMiddleWidth() {
        return SCREEN_WIDTH / 2;
    }

    public double getMiddleHeight() {
        return SCREEN_HEIGHT / 2;
    }
}
