package org.example.chart;

import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.control.ControlLayerImpl;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataLayerImpl;
import org.example.chart.layer.display.DisplayLayer;

import javax.swing.*;
import java.awt.*;

public abstract class DynamicChart extends JPanel {
    private final DataLayer dataLayer;
    private final DisplayLayer displayLayer;
    private final ControlLayer controlLayer;

    public DynamicChart() {
        this.dataLayer = new DataLayerImpl(this);
        this.displayLayer = new DisplayLayer(this);
        this.controlLayer = new ControlLayerImpl(this);
        setUpComponent();
    }

    private void setUpComponent() {
        this.setLayout(new BorderLayout());
        this.add(displayLayer);
        this.setOpaque(false);
    }



}
