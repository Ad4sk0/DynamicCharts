package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;
import java.awt.geom.Line2D;

class YAxisImpl extends Axis {

    public YAxisImpl(DataLayer dataLayer, DataDisplayLayer dataDisplayLayer, DrawingAreaLayer drawingAreaLayer) {
        super(dataLayer, dataDisplayLayer, drawingAreaLayer);
    }

    private double getYPosition(double value) {
        return axisLocation.y + dataDisplayLayer.getYPosition(value);
    }

    private void generateTicks() {
        ticksMap.clear();
        int ticksNumber = axisSize.height / ticksSpacing;
        double tickValueStep = dataLayer.getYAmplitude() / (double) ticksNumber;
        for (int i = 0; i <= ticksNumber; i++) {
            double tickValue = dataLayer.getYMinValue() + tickValueStep * i;
            ticksMap.put(tickValue, getYPosition(tickValue));
        }
    }

    private void drawTicks(Graphics2D g2) {
        double xStart = axisLocation.x - tickHeight;
        g2.setStroke(new BasicStroke(tickThickness));
        g2.setColor(tickColor);
        for (var entry : ticksMap.entrySet()) {
            double value = entry.getKey();
            double yPixel = entry.getValue();
            g2.draw(new Line2D.Double(xStart, yPixel, axisLocation.x, yPixel));
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
        g2.drawLine(axisLocation.x, axisLocation.y, axisLocation.x, axisLocation.y + axisSize.height);
        generateTicks();
        drawTicks(g2);
    }

    @Override
    protected void setUpComponent() {
    }
}
