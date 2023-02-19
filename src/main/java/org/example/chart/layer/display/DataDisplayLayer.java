package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

abstract class DataDisplayLayer extends JPanel {
    public DataDisplayLayer() {
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
