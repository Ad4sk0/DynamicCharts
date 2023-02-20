package org.example;

import org.example.chart.impl.LineChart;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(800, 800);
        LineChart chart = new LineChart();
        jFrame.add(chart);

        double[] x = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] y = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        chart.updateData(x, y);
    }
}