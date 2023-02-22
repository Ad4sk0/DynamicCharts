package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;
import java.util.Objects;

class DataAnalyzeLayerImpl extends DataAnalyzeLayer {

    private Point indicatorPosition;
    private boolean drawIndicator = false;

    public DataAnalyzeLayerImpl(DisplayLayer displayLayer, DataLayer dataLayer) {
        super(displayLayer, dataLayer);
    }

    protected void setUp() {
    }

    @Override
    protected void updateIndicator(Point point, boolean drawIndicator) {
        this.indicatorPosition = point;
        this.drawIndicator = drawIndicator;
        repaint();
    }

    private void drawIndicator(Graphics2D g2, Point point) {
        g2.setStroke(indicatorStroke);
        g2.setColor(indicatorColor);
        g2.drawLine(0, point.y, getWidth(), point.y);
        g2.drawLine(point.x, 0, point.x, getHeight());
    }

    private void drawValue(Graphics2D g2, Point point) {
        g2.setColor(labelColor);
        double xValue = displayLayer.getXValueByPosition(point.x);
        double yValue = displayLayer.getYValueByPosition(point.y);
        String label = String.format("(%.2f,%.2f)", xValue, yValue);
        double x = point.x + labelSpacing;
        double y = point.y - labelSpacing;
        g2.drawString(label, (float) x, (float) y);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (drawIndicator) {
            Objects.requireNonNull(indicatorPosition);
            drawIndicator(g2, indicatorPosition);
            drawValue(g2, indicatorPosition);
            drawIndicator = false;
            indicatorPosition = null;
        }
    }
}
