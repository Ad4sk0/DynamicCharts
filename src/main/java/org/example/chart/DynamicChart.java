package org.example.chart;

import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.display.DisplayLayer;

public interface DynamicChart {
    void updateData(double[] x, double[] y);

    DataLayer getDataLayer();

    DisplayLayer getDisplayLayer();

    ControlLayer getControlLayer();
}
