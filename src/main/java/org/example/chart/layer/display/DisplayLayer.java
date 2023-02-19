package org.example.chart.layer.display;

import javax.swing.*;

public abstract class DisplayLayer extends JPanel {
    protected final BackgroundLayer backgroundLayer;
    protected final DrawingAreaLayer drawingAreaLayer;
    protected final AxisLayer axisLayer;
    protected final DataDisplayLayer dataDisplayLayer;

    public DisplayLayer(BackgroundLayer backgroundLayer, AxisLayer axisLayer, DrawingAreaLayer drawingAreaLayer, DataDisplayLayer dataDisplayLayer) {
        this.backgroundLayer = backgroundLayer;
        this.axisLayer = axisLayer;
        this.drawingAreaLayer = drawingAreaLayer;
        this.dataDisplayLayer = dataDisplayLayer;
        this.add(backgroundLayer);
        this.add(axisLayer);
        this.add(drawingAreaLayer);
        this.add(dataDisplayLayer);
        this.setLayout(null);
        setUp();
    }

    protected abstract void setUp();
}
