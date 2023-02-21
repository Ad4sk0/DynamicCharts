package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

abstract class Axis extends JPanel {

    protected final DataLayer dataLayer;
    protected final DataDisplayLayer dataDisplayLayer;
    protected final DrawingAreaLayer drawingAreaLayer;
    protected final Map<Double, Double> ticksMap;
    protected Point axisLocation = new Point();
    protected Dimension axisSize = new Dimension();
    protected int thickness = 3;
    protected Color color = Color.BLACK;
    protected int ticksSpacing = 50;
    protected int labelSpacing = 10;
    protected int tickHeight = 5;
    protected int tickThickness = 1;
    protected Color tickColor;
    protected DecimalFormat tickLabelFormat = new DecimalFormat("0.00");

    public Axis(DataLayer dataLayer, DataDisplayLayer dataDisplayLayer, DrawingAreaLayer drawingAreaLayer) {
        this.dataLayer = dataLayer;
        this.dataDisplayLayer = dataDisplayLayer;
        this.drawingAreaLayer = drawingAreaLayer;
        this.setLayout(null);
        this.setOpaque(false);
        ticksMap = new HashMap<>();
        setUpComponent();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        drawAxis(g2);
    }

    protected abstract void drawAxis(Graphics2D g2);

    protected abstract void setUpComponent();

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getAxisLocation() {
        return axisLocation;
    }

    public void setAxisLocation(int x, int y) {
        axisLocation.setLocation(x, y);
    }

    public Dimension getAxisSize() {
        return axisSize;
    }

    public void setAxisSize(int width, int height) {
        axisSize.setSize(width, height);
    }
}
