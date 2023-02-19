package org.example.chart.layer.display;

import javax.swing.*;

abstract class DrawingAreaLayer extends JPanel {
    public DrawingAreaLayer() {
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
