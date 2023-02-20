package org.example.chart.layer.control;

import org.example.chart.DynamicChart;

public class ControlLayerImpl implements ControlLayer {
    private final DynamicChart chart;

    public ControlLayerImpl(DynamicChart dynamicChart) {
        this.chart = dynamicChart;
    }
}
