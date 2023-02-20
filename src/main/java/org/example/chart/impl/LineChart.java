package org.example.chart.impl;

import org.example.chart.ChartPanel;
import org.example.chart.DynamicChart;
import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.control.ControlLayerImpl;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataLayerImpl;
import org.example.chart.layer.display.DisplayLayer;

import java.awt.*;

public class LineChart extends ChartPanel implements DynamicChart {

    private final DataLayer dataLayer;
    private final DisplayLayer displayLayer;
    private final ControlLayer controlLayer;

    public LineChart() {
        dataLayer = new DataLayerImpl(this);
        displayLayer = new DisplayLayer(this);
        controlLayer = new ControlLayerImpl(this);
        dataLayer.addListener(displayLayer);
        setupComponent();
    }

    private void setupComponent() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.add(displayLayer);
    }

    @Override
    public void updateData(double[] x, double[] y) {
        dataLayer.updateData(x, y);
    }

    public DataLayer getDataLayer() {
        return dataLayer;
    }

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }

    public ControlLayer getControlLayer() {
        return controlLayer;
    }
}
