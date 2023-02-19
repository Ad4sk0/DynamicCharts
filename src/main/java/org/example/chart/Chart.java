package org.example.chart;

import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.control.ControlLayerImpl;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataLayerImpl;
import org.example.chart.layer.display.DisplayLayer;
import org.example.chart.layer.display.DisplayLayerImpl;

import javax.swing.*;
import java.awt.*;

public class Chart extends JPanel {

    private final DataLayer dataLayer;
    private final DisplayLayer displayLayer;
    private final ControlLayer controlLayer;

    public Chart() {
        this.dataLayer = new DataLayerImpl();
        this.displayLayer = new DisplayLayerImpl();
        this.controlLayer = new ControlLayerImpl();
        this.setLayout(new BorderLayout());
        this.add(displayLayer);
        this.setBackground(Color.GREEN);
    }
}
