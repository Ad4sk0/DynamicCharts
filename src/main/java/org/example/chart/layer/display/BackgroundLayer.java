package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

abstract class BackgroundLayer extends JPanel {
    public BackgroundLayer() {
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
