package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import javax.swing.*;

abstract class DataDisplayLayer extends JPanel {

    private final DisplayLayer displayLayer;
    private final DataLayer dataLayer;

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

    public double getXPosition(double value) {
        double shifted = value - dataLayer.getXMinValue();
        double factor = shifted / dataLayer.getXAmplitude();
        return getWidth() * factor;
    }

    public double getYPosition(double value) {
        double shifted = value - dataLayer.getYMinValue();
        double factor = shifted / dataLayer.getYAmplitude();
        return getHeight() * factor;
    }
}
