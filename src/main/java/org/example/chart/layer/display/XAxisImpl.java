package org.example.chart.layer.display;

import java.awt.*;

class XAxisImpl extends Axis {

    public XAxisImpl(int xMargin, int yMargin) {
        super(xMargin, yMargin);
    }

    @Override
    protected void setUpComponent() {
    }

    @Override
    protected void drawAxis(Graphics2D g2) {
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(color);
        g2.drawLine(xMargin, getHeight() - yMargin, getWidth() - xMargin, getHeight() - yMargin);
    }
}
