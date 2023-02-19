package org.example.chart.layer.display;

import java.awt.*;

class DataDisplayLayerImpl extends DataDisplayLayer {
    public DataDisplayLayerImpl(DisplayLayer displayLayer) {
        super(displayLayer);
    }

    protected void setUp() {
        this.setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.GREEN);
        g2.drawLine(0, 0, 100, 100);
    }
}
