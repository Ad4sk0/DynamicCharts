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

        // Example chart data
        int pointsNumber = 100;
        double[] x = new double[pointsNumber];
        double[] y = new double[pointsNumber];
        for (int i = 0; i < pointsNumber; i++) {
            x[i] = Math.PI / (pointsNumber / 2.0) * i;
            y[i] = Math.sin(x[i]);
        }
        chart.updateData(x, y);
    }
}