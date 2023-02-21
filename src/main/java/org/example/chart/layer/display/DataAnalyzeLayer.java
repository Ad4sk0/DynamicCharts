package org.example.chart.layer.display;

import org.example.chart.layer.data.DataLayer;

import javax.swing.*;
import java.awt.*;

abstract class DataAnalyzeLayer extends JPanel {

    protected final DisplayLayer displayLayer;
    protected final DataLayer dataLayer;
    protected final DrawingAreaLayer drawingAreaLayer;
    protected final DataDisplayLayer dataDisplayLayer;
    protected Color indicatorColor = Color.ORANGE;
    protected int indicatorThickness = 3;
    protected Stroke indicatorStroke = new BasicStroke(indicatorThickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{10}, 1);
    protected int labelSpacing = 10;
    protected Color labelColor = Color.BLACK;

    public DataAnalyzeLayer(DisplayLayer displayLayer, DataLayer dataLayer) {
        this.displayLayer = displayLayer;
        this.dataLayer = dataLayer;
        this.drawingAreaLayer = displayLayer.getDrawingAreaLayer();
        this.dataDisplayLayer = displayLayer.getDataDisplayLayer();
        this.setLayout(null);
        this.setOpaque(false);
        setUp();
    }

    protected abstract void setUp();

    public DisplayLayer getDisplayLayer() {
        return displayLayer;
    }

    protected abstract void updateIndicator(Point point, boolean drawIndicator);
}
