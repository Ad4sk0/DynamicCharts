package org.example.chart.layer.display;

import javax.swing.*;

abstract class DrawingAreaLayer extends JLayeredPane {
    private final DisplayLayer displayLayer;

    public DrawingAreaLayer(DisplayLayer displayLayer) {
        this.displayLayer = displayLayer;
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();


    /**
     * Method for calculating position of x coordinate on drawing plane relative to drawing area.
     *
     * @param value    Value on X-axis.
     * @param minValue Smallest possible value on X-axis.
     * @param maxValue Largest possible value on X-axis.
     * @return Position on X-axis.
     */
    public double getXPosition(double value, double minValue, double maxValue) {
        double amplitude = maxValue - minValue;
        double shifted = value - minValue;
        double factor = shifted / amplitude;
        return getWidth() * factor;
    }

    /**
     * Method for calculating position of y coordinate on drawing plane relative to drawing area.
     *
     * @param value    Value on Y-axis.
     * @param minValue Smallest possible value on Y-axis.
     * @param maxValue Largest possible value on Y-axis.
     * @return Position on Y-axis.
     */
    public double getYPosition(double value, double minValue, double maxValue) {
        double amplitude = maxValue - minValue;
        double shifted = value - minValue;
        double factor = shifted / amplitude;
        return getHeight() - getHeight() * factor;
    }

    /**
     * Method for calculating value of x coordinate given position on drawing plane relative to drawing area.
     *
     * @param xPosition Position on X-axis.
     * @param minValue  Smallest possible value on X-axis.
     * @param maxValue  Largest possible value on X-axis.
     * @return Value on X-axis.
     */
    public double getXValueByPosition(double xPosition, double minValue, double maxValue) {
        double amplitude = maxValue - minValue;
        double factor = xPosition / getWidth();
        return minValue + amplitude * factor;
    }

    /**
     * Method for calculating value of y coordinate given position on drawing plane relative to drawing area.
     *
     * @param yPosition Position on Y-axis.
     * @param minValue  Smallest possible value on Y-axis.
     * @param maxValue  Largest possible value on Y-axis.
     * @return Value on Y-axis.
     */
    public double getYValueByPosition(double yPosition, double minValue, double maxValue) {
        double amplitude = maxValue - minValue;
        double factor = yPosition / getHeight();
        return maxValue - amplitude * factor;
    }

    public abstract int getXMargin();

    public abstract int getYMargin();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
