package org.example.chart.layer.data;

public interface DataSet {

    String getId();

    void updateData(double[] x, double[] y);

    void addListener(DataUpdateListener dataUpdateListener);

    double[] getXValues();

    double getXMinValue();

    double getXMaxValue();

    double getXAmplitude();

    double[] getYValues();

    double getYMinValue();

    double getYMaxValue();

    double getYAmplitude();
}
