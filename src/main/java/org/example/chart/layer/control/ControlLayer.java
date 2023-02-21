package org.example.chart.layer.control;

import java.awt.*;

public interface ControlLayer {
    void moveMouseInDrawingArea(Point point);

    void moveMouseOutsideDrawingArea(Point point);
}
