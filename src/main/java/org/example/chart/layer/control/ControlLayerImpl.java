package org.example.chart.layer.control;

import org.example.chart.layer.display.DisplayLayer;

import java.awt.*;

public class ControlLayerImpl implements ControlLayer {
    private final DisplayLayer displayLayer;

    public ControlLayerImpl(DisplayLayer displayLayer) {
        this.displayLayer = displayLayer;
    }

    @Override
    public void moveMouseInDrawingArea(Point point) {
        displayLayer.updateIndicator(point, true);
    }

    @Override
    public void moveMouseOutsideDrawingArea(Point point) {
        displayLayer.updateIndicator(point, false);
    }
}
