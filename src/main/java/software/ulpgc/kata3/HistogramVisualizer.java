package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class HistogramVisualizer {
    public void displayHistogram(Map<String,Integer> histogram, String title, String categoryAxisLabel, String valueAxisLabel) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : histogram.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), categoryAxisLabel);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                title, categoryAxisLabel, valueAxisLabel,dataset,
                PlotOrientation.VERTICAL,false,true,false
        );

        JFrame frame = new JFrame("Histogram");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
