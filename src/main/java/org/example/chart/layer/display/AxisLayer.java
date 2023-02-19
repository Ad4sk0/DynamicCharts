package org.example.chart.layer.display;

import javax.swing.*;

abstract class AxisLayer extends JPanel {

    private final DisplayLayer displayLayer;

    public AxisLayer(DisplayLayer displayLayer) {
        this.displayLayer = displayLayer;
        this.setLayout(null);
        this.setOpaque(false);
        setUpComponent();
    }

    protected abstract void setUpComponent();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
