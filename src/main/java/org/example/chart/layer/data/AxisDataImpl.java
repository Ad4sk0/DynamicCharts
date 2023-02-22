package org.example.chart.layer.data;

import java.util.Arrays;

class AxisDataImpl implements AxisData {
    private double[] values = new double[0];
    private double minValue = 0;
    private double maxValue = 0;

    @Override
    public void updateData(double[] values) {
        this.values = values;
        this.minValue = Arrays.stream(values).min().orElse(0);
        this.maxValue = Arrays.stream(values).max().orElse(0);
    }

    public double[] getValues() {
        return values;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getAmplitude() {
        return maxValue - minValue;
    }
}
