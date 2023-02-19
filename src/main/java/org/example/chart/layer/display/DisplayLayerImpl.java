package org.example.chart.layer.display;

import javax.swing.*;
import java.awt.*;

public class DisplayLayerImpl extends DisplayLayer {
    public DisplayLayerImpl() {
        super(new BackgroundLayerImpl(), new AxisLayerImpl(), new DrawingAreaLayerImpl(), new DataDisplayLayerImpl());
    }

    protected void setUp() {
        this.setBackground(Color.BLACK);

        int width = 100;
        int height = 100;

        axisLayer.setSize(width, height);
        backgroundLayer.setSize(width, height);
        dataDisplayLayer.setSize(width, height);
        drawingAreaLayer.setSize(width, height);
        backgroundLayer.setLocation(0,0);
        axisLayer.setLocation(20,20);
        drawingAreaLayer.setLocation(40,40);
        dataDisplayLayer.setLocation(60,60);

    }
}
