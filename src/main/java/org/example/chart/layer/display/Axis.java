package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

abstract class Axis extends JPanel {

    protected int xMargin;
    protected int yMargin;
    protected int thickness;
    protected Color color;

    public Axis(int xMargin, int yMargin) {
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.thickness = 3;
        this.setLayout(null);
        this.setOpaque(false);
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

    public int getXMargin() {
        return xMargin;
    }

    public void setXMargin(int xPos) {
        this.xMargin = xPos;
    }

    public int getYMargin() {
        return yMargin;
    }

    public void setYMargin(int yPos) {
        this.yMargin = yPos;
    }

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
}
