/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lorenzeode;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static lorenzeode.LorenzFrame.jTableODE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;



public class XYLineChartExample extends JFrame {

    
    public XYLineChartExample() {
        super("XY Line Chart with JFreechart");
 
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel() {
    String chartTitle = "ODE Predictions";
    String xAxisLabel = "Time";
    String yAxisLabel = "Intensity";
   
    
    
   
    XYDataset dataset = createDataset();
 
    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
            xAxisLabel, yAxisLabel, dataset);
 
    return new ChartPanel(chart);
}
 
    private XYDataset createDataset() {
    XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries series1 = new XYSeries("Series1");
    
     //int PlotStart = LorenzFrame.jSpinnerPlotStart;
     //int PlotEnd = LorenzFrame.jSpinnerPlotEnd;

    DefaultTableModel model = (DefaultTableModel) jTableODE.getModel(); 
    int nRow = model.getRowCount(), nCol = model.getColumnCount();
    
    //if (PlotEnd>= nRow){ 
     //   PlotEnd =nRow-5;
   // }
    
    
    double [] td = new double[nRow];
    double[] sd= new double[nRow];
    
    for (int i = 0; i < nRow; i++) {
    td[i] = Double.parseDouble(jTableODE.getValueAt(i, 0).toString());
    sd[i] = Double.parseDouble(jTableODE.getValueAt(i, 3).toString());
    }
    
    for (int j=1; j<nRow; j++){
        series1.add(td[j], sd[j]);
    }
    dataset.addSeries(series1);
    
    //}
     return dataset;
}
      
 
}



 
   

