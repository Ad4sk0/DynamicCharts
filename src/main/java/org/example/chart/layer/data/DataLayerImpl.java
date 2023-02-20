package org.example.chart.layer.data;

import org.example.chart.DynamicChart;

public class DataLayerImpl implements DataLayer {

    private final DynamicChart chart;
    double[] xValues;
    double[] yValues;

    public DataLayerImpl(DynamicChart dynamicChart) {
        this.chart = dynamicChart;
    }
}
