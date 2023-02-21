package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import javax.swing.*;
import java.awt.*;

abstract class DataDisplayLayer extends JPanel {

    protected final DisplayLayer displayLayer;
    protected final DataLayer dataLayer;

    protected Color drawingColor = Color.GREEN;
    protected int drawingThickness = 1;

    public DataDisplayLayer(DisplayLayer displayLayer, DataLayer dataLayer) {
        this.displayLayer = displayLayer;
        this.dataLayer = dataLayer;
        this.setLayout(null);
        this.setOpaque(false);
        setUp();
    }

    protected abstract void setUp();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }

    /**
     * Main method for calculating position of x coordinate on drawing plane.
     *
     * @param value Value on X-axis.
     * @return Pixel position on X-axis.
     */
    public double getXPosition(double value) {
        double shifted = value - dataLayer.getXMinValue();
        double factor = shifted / dataLayer.getXAmplitude();
        return getWidth() * factor;
    }

    /**
     * Main method for calculating position of y coordinate on drawing plane.
     *
     * @param value Value on Y-axis.
     * @return Pixel position on Y-axis
     */
    public double getYPosition(double value) {
        double shifted = value - dataLayer.getYMinValue();
        double factor = shifted / dataLayer.getYAmplitude();
        return getHeight() - getHeight() * factor;
    }

    /**
     * Main method for calculating value of x coordinate given position on drawing plane.
     *
     * @param xPosition Position on X-axis.
     * @return Value on X-axis.
     */
    public double getXValueByPosition(double xPosition) {
        double factor = xPosition / getWidth();
        return dataLayer.getXMinValue() + dataLayer.getXAmplitude() * factor;
    }

    /**
     * Main method for calculating value of y coordinate given position on drawing plane.
     *
     * @param yPosition Position on Y-axis.
     * @return Value on Y-axis.
     */
    public double getYValueByPosition(double yPosition) {
        double factor = yPosition / getHeight();
        return dataLayer.getYMaxValue() - dataLayer.getYAmplitude() * factor;
    }
}
