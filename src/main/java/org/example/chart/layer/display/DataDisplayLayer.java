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
     * Main method for position x coordinate on drawing plane.
     *
     * @param value Value on x axis.
     * @return Pixel position on x axis.
     */
    public double getXPosition(double value) {
        double shifted = value - dataLayer.getXMinValue();
        double factor = shifted / dataLayer.getXAmplitude();
        return getWidth() * factor;
    }

    /**
     * Main method for position y coordinate on drawing plane.
     *
     * @param value Value on y axis.
     * @return Pixel position on ys axis
     */
    public double getYPosition(double value) {
        double shifted = value - dataLayer.getYMinValue();
        double factor = shifted / dataLayer.getYAmplitude();
        return getHeight() - getHeight() * factor;
    }
}
