package org.example.chart.layer.display;

import javax.swing.*;

abstract class DataDisplayLayer extends JPanel {

    private final DisplayLayer displayLayer;

    public DataDisplayLayer(DisplayLayer displayLayer) {
        this.displayLayer = displayLayer;
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
