package kata4.bd;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import static sun.awt.image.BufImgSurfaceData.createData;

public class HistogramDisplay extends ApplicationFrame {
    
    private final Histogram<String> histo;

    public HistogramDisplay(Histogram<String> histo) {
        super("HISTOGRAMA");
        this.histo = histo;
        setContentPane(createPanel());
        pack();
    }
    private ChartPanel createPanel () {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 450));
        return chartPanel;
    }
    
    private JFreeChart createChart (DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(null, "DOMINIOS", "Nº emails", dataset, PlotOrientation.VERTICAL, false, false, false);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset () {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (String key : histo.keySet()) {
            dataset.addValue(histo.get(key), "", key);
        }
        return dataset;
    }
        public void execute() {
            setVisible(true);
        }
    }