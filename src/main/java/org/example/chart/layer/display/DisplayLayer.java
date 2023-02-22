package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataSet;
import org.example.chart.layer.data.DataUpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

public class DisplayLayer extends JLayeredPane implements DataUpdateListener {

    private final DataLayer dataLayer;
    private final BackgroundLayer backgroundLayer;
    private final DrawingAreaLayer drawingAreaLayer;
    private final AxisLayer axisLayer;
    private final Map<String, DataDisplayLayer> dataDisplayLayerMap;
    private final DataAnalyzeLayer dataAnalyzeLayer;

    public DisplayLayer(DataLayer dataLayer) {
        this.dataLayer = dataLayer;
        this.backgroundLayer = new BackgroundLayerImpl(this);
        this.drawingAreaLayer = new DrawingAreaLayerImpl(this);
        this.dataDisplayLayerMap = new HashMap<>();
        setupDataDisplayLayers();
        this.dataAnalyzeLayer = new DataAnalyzeLayerImpl(this, dataLayer);
        this.axisLayer = new AxisLayerImpl(this, dataLayer);
        setUpLayers();
        setUpController();
    }

    private void setupDataDisplayLayers() {
        dataDisplayLayerMap.clear();
        for (DataSet dataSet : dataLayer.getDataSetMap().values()) {
            addDataSet(dataSet);
        }
    }

    private void setUpLayers() {
        this.add(backgroundLayer, Integer.valueOf(0));
        this.add(drawingAreaLayer, Integer.valueOf(100));
        this.add(axisLayer, Integer.valueOf(200));
        drawingAreaLayer.add(dataAnalyzeLayer, Integer.valueOf(100));
    }

    private void setUpController() {
    }

    public void addDataSet(DataSet dataSet) {
        var dataDisplayLayer = new DataDisplayLayerImpl(this, dataSet);
        dataDisplayLayerMap.put(dataSet.getId(), dataDisplayLayer);
        drawingAreaLayer.add(dataDisplayLayer, Integer.valueOf(0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        axisLayer.setSize(getWidth(), getHeight());
        backgroundLayer.setSize(getWidth(), getHeight());
        setUpDrawingArea();
    }

    private void setUpDrawingArea() {
        int x = drawingAreaLayer.getXMargin();
        int y = drawingAreaLayer.getYMargin();
        int width = getWidth() - drawingAreaLayer.getXMargin() * 2;
        int height = getHeight() - drawingAreaLayer.getYMargin() * 2;
        drawingAreaLayer.setLocation(x, y);
        drawingAreaLayer.setSize(width, height);
        for (var dataDisplayLayer : dataDisplayLayerMap.values()) {
            dataDisplayLayer.setSize(width, height);
        }
        dataAnalyzeLayer.setSize(width, height);
    }

    public void updateIndicator(Point point, boolean drawIndicator) {
        dataAnalyzeLayer.updateIndicator(point, drawIndicator);
    }

    /**
     * Main method for calculating position of x coordinate on drawing plane.
     *
     * @param value Value on X-axis.
     * @return Pixel position on X-axis.
     */
    public double getXPosition(double value) {
        return drawingAreaLayer.getXPosition(value, dataLayer.getXMinValue(), dataLayer.getXMaxValue());
    }

    /**
     * Main method for calculating position of y coordinate on drawing plane.
     *
     * @param value Value on Y-axis.
     * @return Pixel position on Y-axis
     */
    public double getYPosition(double value) {
        return drawingAreaLayer.getYPosition(value, dataLayer.getYMinValue(), dataLayer.getYMaxValue());
    }

    /**
     * Main method for calculating value of x coordinate given position on drawing plane.
     *
     * @param xPosition Position on X-axis.
     * @return Value on X-axis.
     */
    public double getXValueByPosition(double xPosition) {
        return drawingAreaLayer.getXValueByPosition(xPosition, dataLayer.getXMinValue(), dataLayer.getXMaxValue());
    }

    /**
     * Main method for calculating value of y coordinate given position on drawing plane.
     *
     * @param yPosition Position on Y-axis.
     * @return Value on Y-axis.
     */
    public double getYValueByPosition(double yPosition) {
        return drawingAreaLayer.getYValueByPosition(yPosition, dataLayer.getYMinValue(), dataLayer.getYMaxValue());
    }

    public BackgroundLayer getBackgroundLayer() {
        return backgroundLayer;
    }

    public DrawingAreaLayer getDrawingAreaLayer() {
        return drawingAreaLayer;
    }

    public AxisLayer getAxisLayer() {
        return axisLayer;
    }

    @Override
    public void handleDataUpdate(DataLayer dataLayer) {
        repaint();
    }

    public void addDrawingAreaMouseListeners(MouseListener mouseListener, MouseMotionListener mouseMotionListener) {
        drawingAreaLayer.addMouseListener(mouseListener);
        drawingAreaLayer.addMouseMotionListener(mouseMotionListener);
    }
}
