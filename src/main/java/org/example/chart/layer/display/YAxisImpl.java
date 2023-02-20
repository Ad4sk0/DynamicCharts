package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;
import java.awt.geom.Line2D;

class YAxisImpl extends Axis {

    public YAxisImpl(DataLayer dataLayer, DataDisplayLayer dataDisplayLayer, DrawingAreaLayer drawingAreaLayer) {
        super(dataLayer, dataDisplayLayer, drawingAreaLayer);
    }

    private void generateTicks() {
        ticksMap.clear();
        int ticksNumber = getHeight() / ticksSpacing;
        double tickValueStep = dataLayer.getYAmplitude() / (double) ticksNumber;
        for (int i = 1; i < ticksNumber; i++) {
            double tickValue = dataLayer.getYMinValue() + tickValueStep * i;
            ticksMap.put(tickValue, getHeight() - dataDisplayLayer.getYPosition(tickValue));
        }
    }

    private void drawTicks(Graphics2D g2, int x) {
        double xStart = x - tickHeight;
        g2.setStroke(new BasicStroke(tickThickness));
        g2.setColor(tickColor);
        for (var entry : ticksMap.entrySet()) {
            double value = entry.getKey();
            double yPixel = entry.getValue();
            g2.draw(new Line2D.Double(xStart, yPixel, x, yPixel));
            drawTickLabel(value, g2, yPixel, xStart);
        }
    }

    private void drawTickLabel(double tickValue, Graphics2D g2, double tickY, double tickXStart) {
        String label = tickLabelFormat.format(tickValue);
        int labelWidth = g2.getFontMetrics().stringWidth(label);
        int labelHeight = g2.getFontMetrics().getHeight();
        double x = tickXStart - labelSpacing - labelWidth;
        double y = tickY + labelHeight / 4.0;
        g2.drawString(label, (float) x, (float) y);
    }

    @Override
    protected void drawAxis(Graphics2D g2) {
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(color);
        int xPosition = drawingAreaLayer.getXMargin();
        g2.drawLine(xPosition, 0, xPosition, getHeight());
        generateTicks();
        drawTicks(g2, xPosition);
    }

    @Override
    protected void setUpComponent() {
    }
}
