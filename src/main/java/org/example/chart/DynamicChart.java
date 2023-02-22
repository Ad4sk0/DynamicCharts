package org.example.chart;

import org.example.chart.layer.control.ControlLayer;
import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.display.DisplayLayer;

public interface DynamicChart {
    void updateData(double[] x, double[] y);

    void updateData(String dataSetId, double[] x, double[] y);

    void addDataSet(String dataSetId);

    DataLayer getDataLayer();

    DisplayLayer getDisplayLayer();

    ControlLayer getControlLayer();
}
