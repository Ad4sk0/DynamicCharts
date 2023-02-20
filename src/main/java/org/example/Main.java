package org.example;

import org.example.chart.DynamicChart;
import org.example.chart.impl.ExampleChart;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(800, 800);
        DynamicChart chart = new ExampleChart();
        jFrame.add(chart);

    }
}