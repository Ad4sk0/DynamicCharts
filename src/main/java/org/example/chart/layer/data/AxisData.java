package org.example.chart.layer.data;

public interface AxisData {
    void updateData(double[] values);

    double[] getValues();

    double getMinValue();

    double getMaxValue();

    double getAmplitude();
}
