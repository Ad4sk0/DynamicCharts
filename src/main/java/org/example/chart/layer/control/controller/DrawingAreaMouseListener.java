package org.example.chart.layer.control.controller;

import org.example.chart.layer.control.ControlLayer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingAreaMouseListener implements MouseListener {
    private final ControlLayer controlLayer;

    public DrawingAreaMouseListener(ControlLayer controlLayer) {
        this.controlLayer = controlLayer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        controlLayer.moveMouseOutsideDrawingArea(e.getPoint());
    }
}
