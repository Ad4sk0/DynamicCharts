package org.example.chart.layer.data;

interface AxisData {
    void updateData(double[] values);

    double[] getValues();

    double getMinValue();

    double getMaxValue();

    double getAmplitude();
}
