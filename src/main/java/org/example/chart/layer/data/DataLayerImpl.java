package org.example.chart.layer.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLayerImpl implements DataLayer {
    private final Map<String, DataSet> dataSetMap;
    private final List<DataUpdateListener> listeners;
    private final DataSet defaultDataSet;

    public DataLayerImpl() {
        dataSetMap = new HashMap<>();
        listeners = new ArrayList<>();
        String defaultDataSetId = "1";
        defaultDataSet = new DataSetImpl(defaultDataSetId);
        dataSetMap.put(defaultDataSetId, defaultDataSet);
    }

    @Override
    public DataSet addDataSet(String dataSetId) {
        if (dataSetMap.containsKey(dataSetId)) {
            throw new IllegalArgumentException("Data set with id " + dataSetId + " already exists");
        }
        var dataSet = new DataSetImpl(dataSetId);
        dataSetMap.put(dataSetId, dataSet);
        return dataSet;
    }

    @Override
    public void updateData(double[] x, double[] y) {
        defaultDataSet.updateData(x, y);
        notifyListeners();
    }

    @Override
    public void updateData(String dataSetId, double[] x, double[] y) {
        if (!dataSetMap.containsKey(dataSetId)) {
            throw new IllegalArgumentException("Data set with id " + dataSetId + " does not exist");
        }
        dataSetMap.get(dataSetId).updateData(x, y);
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

    public double getXMinValue() {
        double min = 0;
        for (var dataSet : dataSetMap.values()) {
            min = Math.min(min, dataSet.getXMinValue());
        }
        return min;
    }

    public double getXMaxValue() {
        double max = 0;
        for (var dataSet : dataSetMap.values()) {
            max = Math.max(max, dataSet.getXMaxValue());
        }
        return max;
    }

    public double getXAmplitude() {
        return getXMaxValue() - getXMinValue();
    }

    public double getYMinValue() {
        double min = 0;
        for (var dataSet : dataSetMap.values()) {
            min = Math.min(min, dataSet.getYMinValue());
        }
        return min;
    }

    public double getYMaxValue() {
        double max = 0;
        for (var dataSet : dataSetMap.values()) {
            max = Math.max(max, dataSet.getYMaxValue());
        }
        return max;
    }

    public double getYAmplitude() {
        return getYMaxValue() - getYMinValue();
    }

    public Map<String, DataSet> getDataSetMap() {
        return dataSetMap;
    }
}
