package org.example.chart.layer.display;

import java.awt.*;

class AxisLayerImpl extends AxisLayer {

    private final Axis xAxis;
    private final Axis yAxis;

    public AxisLayerImpl(DisplayLayer displayLayer) {
        super(displayLayer);
        int xMargin = displayLayer.getDrawingAreaLayer().getXMargin();
        int yMargin = displayLayer.getDrawingAreaLayer().getYMargin();
        xAxis = new XAxisImpl(xMargin, yMargin);
        yAxis = new YAxisImpl(xMargin, yMargin);
        this.add(xAxis);
        this.add(yAxis);
    }

    protected void setUpComponent() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        xAxis.setSize(getWidth(), getHeight());
        yAxis.setSize(getWidth(), getHeight());
    }
}
