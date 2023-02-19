package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

abstract class AxisLayer extends JPanel {
    public AxisLayer() {
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
