package org.example.chart.layer.display;

import org.example.chart.layer.data.DataSet;

import java.awt.*;
import java.awt.geom.Path2D;

class DataDisplayLayerImpl extends DataDisplayLayer {
    public DataDisplayLayerImpl(DisplayLayer displayLayer, DataSet dataSet) {
        super(displayLayer, dataSet);
    }

    protected void setUp() {
    }

    private void drawLine(Graphics2D g2, double[] xArray, double[] yArray) {
        int pointsNumber = Math.min(xArray.length, yArray.length);
        Path2D path2D = new Path2D.Double();
        for (int i = 0; i < pointsNumber; i++) {
            double x = displayLayer.getXPosition(xArray[i]);
            double y = displayLayer.getYPosition(yArray[i]);
            if (i == 0) {
                path2D.moveTo(x, y);
            } else {
                path2D.lineTo(x, y);
            }
        }
        g2.draw(path2D);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(drawingThickness));
        g2.setColor(drawingColor);
        drawLine(g2, dataSet.getXValues(), dataSet.getYValues());
    }
}
