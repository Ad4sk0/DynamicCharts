package org.example.chart.impl;

import org.example.chart.ChartPanel;
import org.example.chart.DynamicChart;
import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.control.ControlLayerImpl;
import org.example.chart.layer.control.controller.DrawingAreaMouseListener;
import org.example.chart.layer.control.controller.DrawingAreaMouseMotionListener;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataLayerImpl;
import org.example.chart.layer.data.DataSet;
import org.example.chart.layer.display.DisplayLayer;

import java.awt.*;

public class LineChart extends ChartPanel implements DynamicChart {

    private final DataLayer dataLayer;
    private final DisplayLayer displayLayer;
    private final ControlLayer controlLayer;

    public LineChart() {
        dataLayer = new DataLayerImpl();
        displayLayer = new DisplayLayer(dataLayer);
        controlLayer = new ControlLayerImpl(displayLayer);
        dataLayer.addListener(displayLayer);
        displayLayer.addDrawingAreaMouseListeners(new DrawingAreaMouseListener(controlLayer), new DrawingAreaMouseMotionListener(controlLayer));
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
    @Override
    public void updateData(String dataSetId, double[] x, double[] y) {
        dataLayer.updateData(dataSetId, x, y);
    }

    @Override
    public void addDataSet(String dataSetId) {
        DataSet dataSet = dataLayer.addDataSet(dataSetId);
        displayLayer.addDataSet(dataSet);
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
