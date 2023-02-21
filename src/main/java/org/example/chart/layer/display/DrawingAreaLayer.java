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

    public abstract int getXMargin();

    public abstract int getYMargin();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
