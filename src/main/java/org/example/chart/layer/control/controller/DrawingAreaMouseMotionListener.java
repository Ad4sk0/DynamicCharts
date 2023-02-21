package org.example.chart.layer.control.controller;

import org.example.chart.layer.control.ControlLayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawingAreaMouseMotionListener implements MouseMotionListener {
    private final ControlLayer controlLayer;

    public DrawingAreaMouseMotionListener(ControlLayer controlLayer) {
        this.controlLayer = controlLayer;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        controlLayer.moveMouseInDrawingArea(e.getPoint());
    }
}
