package org.example.chart.layer.display;

import org.example.chart.layer.data.DataSet;

import javax.swing.*;
import java.awt.*;

abstract class DataDisplayLayer extends JPanel {

    protected final DisplayLayer displayLayer;
    protected final DataSet dataSet;

    protected Color drawingColor = Color.GREEN;
    protected int drawingThickness = 1;

    public DataDisplayLayer(DisplayLayer displayLayer, DataSet dataSet) {
        this.displayLayer = displayLayer;
        this.dataSet = dataSet;
        this.setLayout(null);
        this.setOpaque(false);
        setUp();
    }

    protected abstract void setUp();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }
}
