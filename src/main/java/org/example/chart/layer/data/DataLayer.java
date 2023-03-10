package org.example.chart.layer.data;

import java.util.Map;

public interface DataLayer {
    DataSet addDataSet(String dataSetId);
    void updateData(double[] x, double[] y);
    void updateData(String dataSetId, double[] x, double[] y);

    void addListener(DataUpdateListener dataUpdateListener);

    double getXMinValue();

    double getXMaxValue();

    double getXAmplitude();

    double getYMinValue();

    double getYMaxValue();

    double getYAmplitude();

    Map<String, DataSet> getDataSetMap();
}
