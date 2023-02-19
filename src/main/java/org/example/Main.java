package org.example;

import org.example.chart.Chart;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setSize(800, 800);
        Chart exampleChart = new Chart();
        jFrame.add(exampleChart);
    }
}