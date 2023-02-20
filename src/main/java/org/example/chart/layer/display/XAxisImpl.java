package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import java.awt.*;
import java.awt.geom.Line2D;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class XAxisImpl extends Axis {

    public XAxisImpl(DataLayer dataLayer, DataDisplayLayer dataDisplayLayer, DrawingAreaLayer drawingAreaLayer) {
        super(dataLayer, dataDisplayLayer, drawingAreaLayer);
    }

    private void generateTicks() {
        ticksMap.clear();
        int ticksNumber = getWidth() / ticksSpacing;
        double tickValueStep = dataLayer.getXAmplitude() / (double) ticksNumber;
        for (int i = 1; i < ticksNumber; i++) {
            double tickValue = dataLayer.getXMinValue() + tickValueStep * i;
            ticksMap.put(tickValue, dataDisplayLayer.getXPosition(tickValue));
        }
    }

    private void drawTicks(Graphics2D g2, int y) {
        double yStart = y - tickHeight;
        g2.setStroke(new BasicStroke(tickThickness));
        g2.setColor(tickColor);
        for (var entry : ticksMap.entrySet()) {
            double value = entry.getKey();
            double xPixel = entry.getValue();
            g2.draw(new Line2D.Double(xPixel, yStart, xPixel, y));
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
        int yPosition = getHeight() - drawingAreaLayer.getYMargin();
        g2.drawLine(0, yPosition, getWidth(), yPosition);
        generateTicks();
        drawTicks(g2, yPosition);
    }

    @Override
    protected void setUpComponent() {
    }
}
