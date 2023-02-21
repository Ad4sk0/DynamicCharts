package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;

class AxisLayerImpl extends AxisLayer {

    private final Axis xAxis;
    private final Axis yAxis;
    private final DrawingAreaLayer drawingAreaLayer;

    public AxisLayerImpl(DisplayLayer displayLayer, DataLayer dataLayer) {
        super(displayLayer, dataLayer);
        drawingAreaLayer = displayLayer.getDrawingAreaLayer();
        xAxis = new XAxisImpl(dataLayer, displayLayer.getDataDisplayLayer(), drawingAreaLayer);
        yAxis = new YAxisImpl(dataLayer, displayLayer.getDataDisplayLayer(), drawingAreaLayer);
        this.add(xAxis);
        this.add(yAxis);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        xAxis.setLocation(getX(), getY());
        yAxis.setLocation(getX(), getY());
        xAxis.setSize(getWidth(), getHeight());
        yAxis.setSize(getWidth(), getWidth());

        xAxis.setAxisLocation(drawingAreaLayer.getX(), drawingAreaLayer.getY() + drawingAreaLayer.getHeight());
        xAxis.setAxisSize(drawingAreaLayer.getWidth(), drawingAreaLayer.getHeight());
        yAxis.setAxisLocation(drawingAreaLayer.getX(), drawingAreaLayer.getY());
        yAxis.setAxisSize(drawingAreaLayer.getWidth(), drawingAreaLayer.getHeight());
    }

    @Override
    protected void setUpComponent() {
    }
}
