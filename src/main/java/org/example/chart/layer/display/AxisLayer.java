package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import javax.swing.*;

abstract class AxisLayer extends JPanel {

    private final DisplayLayer displayLayer;
    private final DataLayer dataLayer;

    public AxisLayer(DisplayLayer displayLayer, DataLayer dataLayer) {
        this.displayLayer = displayLayer;
        this.dataLayer = dataLayer;
        this.setLayout(null);
        this.setOpaque(false);
        setUpComponent();
    }

    protected abstract void setUpComponent();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
