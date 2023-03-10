package org.example.chart.layer.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataSetImpl implements DataSet {

    private final String id;
    private String title;
    private final AxisData xAxis;
    private final AxisData yAxis;
    private final List<DataUpdateListener> listeners;

    public DataSetImpl(String id) {
        Objects.requireNonNull(id);
        this.id = id;
        xAxis = new AxisDataImpl();
        yAxis = new AxisDataImpl();
        listeners = new ArrayList<>();
    }


    @Override
    public void updateData(double[] x, double[] y) {
        xAxis.updateData(x);
        yAxis.updateData(y);
    }

    @Override
    public void addListener(DataUpdateListener listener) {
        listeners.add(listener);
    }

    @Override
    public String getId() {
        return id;
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
