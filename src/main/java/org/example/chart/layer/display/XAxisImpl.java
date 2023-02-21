package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;
import java.awt.geom.Line2D;

class XAxisImpl extends Axis {

    public XAxisImpl(DataLayer dataLayer, DataDisplayLayer dataDisplayLayer, DrawingAreaLayer drawingAreaLayer) {
        super(dataLayer, dataDisplayLayer, drawingAreaLayer);
    }

    private double getXPosition(double value) {
        return axisLocation.x + dataDisplayLayer.getXPosition(value);
    }

    private void generateTicks() {
        ticksMap.clear();
        int ticksNumber = axisSize.width / ticksSpacing;
        double tickValueStep = dataLayer.getXAmplitude() / (double) ticksNumber;
        for (int i = 1; i < ticksNumber; i++) {
            double tickValue = dataLayer.getXMinValue() + tickValueStep * i;
            ticksMap.put(tickValue, getXPosition(tickValue));
        }
    }

    private void drawTicks(Graphics2D g2) {
        double yStart = axisLocation.y - tickHeight;
        g2.setStroke(new BasicStroke(tickThickness));
        g2.setColor(tickColor);
        for (var entry : ticksMap.entrySet()) {
            double value = entry.getKey();
            double xPixel = entry.getValue();
            g2.draw(new Line2D.Double(xPixel, yStart, xPixel, axisLocation.y));
            drawTickLabel(value, g2, xPixel, yStart);
        }
    }

    private void drawTickLabel(double tickValue, Graphics2D g2, double tickX, double tickYStart) {
        String label = tickLabelFormat.format(tickValue);
        int labelWidth = g2.getFontMetrics().stringWidth(label);
        double x = tickX - labelWidth / 2.0;
        double y = tickYStart - labelSpacing;
        g2.drawString(label, (float) x, (float) y);
    }

    @Override
    protected void drawAxis(Graphics2D g2) {
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(color);
        g2.drawLine(axisLocation.x, axisLocation.y, axisLocation.x + axisSize.width, axisLocation.y);
        generateTicks();
        drawTicks(g2);
    }

    @Override
    protected void setUpComponent() {
    }
}
