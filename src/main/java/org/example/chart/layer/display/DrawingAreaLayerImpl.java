package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

class DrawingAreaLayerImpl extends DrawingAreaLayer {
    private final int xMargin = 50;
    private final int yMargin = 50;

    public DrawingAreaLayerImpl(DisplayLayer displayLayer) {
        super(displayLayer);
    }

    protected void setUp() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    public int getXMargin() {
        return xMargin;
    }

    public int getYMargin() {
        return yMargin;
    }
}
