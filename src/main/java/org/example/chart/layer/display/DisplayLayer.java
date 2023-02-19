package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

public class DisplayLayer extends JLayeredPane {
    private final BackgroundLayer backgroundLayer;
    private final DrawingAreaLayer drawingAreaLayer;
    private final AxisLayer axisLayer;
    private final DataDisplayLayer dataDisplayLayer;

    public DisplayLayer() {
        this.backgroundLayer = new BackgroundLayerImpl(this);
        this.drawingAreaLayer = new DrawingAreaLayerImpl(this);
        this.dataDisplayLayer = new DataDisplayLayerImpl(this);
        this.axisLayer = new AxisLayerImpl(this);
        setUpLayers();
    }

    private void setUpLayers() {
        this.add(backgroundLayer, Integer.valueOf(0));
        this.add(drawingAreaLayer, Integer.valueOf(100));
        this.add(axisLayer, Integer.valueOf(200));
        drawingAreaLayer.add(dataDisplayLayer);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        axisLayer.setSize(getWidth(), getHeight());
        backgroundLayer.setSize(getWidth(), getHeight());
        dataDisplayLayer.setSize(getWidth(), getHeight());
        setUpDrawingArea();
    }

    private void setUpDrawingArea() {
        int x = drawingAreaLayer.getXMargin();
        int y = drawingAreaLayer.getYMargin();
        int width = getWidth() - drawingAreaLayer.getXMargin() * 2;
        int height = getHeight() - drawingAreaLayer.getYMargin() * 2;
        drawingAreaLayer.setLocation(x, y);
        drawingAreaLayer.setSize(width, height);
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
}
