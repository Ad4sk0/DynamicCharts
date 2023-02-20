package org.example.chart.layer.data;

import org.example.chart.DynamicChart;

import java.util.ArrayList;
import java.util.List;

public class DataLayerImpl implements DataLayer {

    private final DynamicChart chart;
    private final AxisData xAxis;
    private final AxisData yAxis;

    private final List<DataUpdateListener> listeners;

    public DataLayerImpl(DynamicChart dynamicChart) {
        xAxis = new AxisDataImpl();
        yAxis = new AxisDataImpl();
        chart = dynamicChart;
        listeners = new ArrayList<>();
    }

    @Override
    public void updateData(double[] x, double[] y) {
        xAxis.updateData(x);
        yAxis.updateData(y);
        notifyListeners();
    }

    private void notifyListeners() {
        for (var listener : listeners) {
            listener.handleDataUpdate(this);
        }
    }

    @Override
    public void addListener(DataUpdateListener listener) {
        listeners.add(listener);
    }

    public double[] getXValues() {
        return xAxis.getValues();
    }

    public double getXMinValue() {
        return xAxis.getMinValue();
    }

    public double getXMaxValue() {
        return xAxis.getMaxValue();
    }

    public double getXAmplitude() {
        return xAxis.getAmplitude();
    }

    public double[] getYValues() {
        return yAxis.getValues();
    }

    public double getYMinValue() {
        return yAxis.getMinValue();
    }

    public double getYMaxValue() {
        return yAxis.getMaxValue();
    }

    public double getYAmplitude() {
        return yAxis.getAmplitude();
    }
}
