package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;
import org.example.chart.layer.data.DataUpdateListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DisplayLayer extends JLayeredPane implements DataUpdateListener {
    private final BackgroundLayer backgroundLayer;
    private final DrawingAreaLayer drawingAreaLayer;
    private final AxisLayer axisLayer;
    private final DataDisplayLayer dataDisplayLayer;
    private final DataAnalyzeLayer dataAnalyzeLayer;

    public DisplayLayer(DataLayer dataLayer) {
        this.backgroundLayer = new BackgroundLayerImpl(this);
        this.drawingAreaLayer = new DrawingAreaLayerImpl(this);
        this.dataDisplayLayer = new DataDisplayLayerImpl(this, dataLayer);
        this.dataAnalyzeLayer = new DataAnalyzeLayerImpl(this, dataLayer);
        this.axisLayer = new AxisLayerImpl(this, dataLayer);
        setUpLayers();
        setUpController();
    }

    private void setUpLayers() {
        this.add(backgroundLayer, Integer.valueOf(0));
        this.add(drawingAreaLayer, Integer.valueOf(100));
        this.add(axisLayer, Integer.valueOf(200));
        drawingAreaLayer.add(dataDisplayLayer, Integer.valueOf(0));
        drawingAreaLayer.add(dataAnalyzeLayer, Integer.valueOf(100));
    }

    private void setUpController() {
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
        dataDisplayLayer.setSize(width, height);
        dataAnalyzeLayer.setSize(width, height);
    }

    public void updateIndicator(Point point, boolean drawIndicator) {
        dataAnalyzeLayer.updateIndicator(point, drawIndicator);
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

    public DataDisplayLayer getDataDisplayLayer() {
        return dataDisplayLayer;
    }

    @Override
    public void handleDataUpdate(DataLayer dataLayer) {
        repaint();
    }

    public void addDrawingAreaMouseListeners(MouseListener mouseListener, MouseMotionListener mouseMotionListener) {
        dataDisplayLayer.addMouseListener(mouseListener);
        dataDisplayLayer.addMouseMotionListener(mouseMotionListener);
    }
}
