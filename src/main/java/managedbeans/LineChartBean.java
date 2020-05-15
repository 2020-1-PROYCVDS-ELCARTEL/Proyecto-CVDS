package managedbeans;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean (name = "lineChartBean")
@ViewScoped
public class LineChartBean {
    private LineChartModel lineModel;
    private BarChartModel barModel;

    @PostConstruct
    public void init() {
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();

        barModel = new BarChartModel();
        ChartSeries boys = new ChartSeries();

        s.setLabel("Dependencias");

        s.set(1, 1);
        s.set(2, 2);
        s.set(3, 3);
        s.set(4, 4);
        s.set(5, 5);
        
        lineModel.addSeries(s);
        lineModel.setLegendPosition("e");

        Axis y = lineModel.getAxis(AxisType.Y);
        y.setMin(0);
        y.setMax(6);
        y.setLabel("Iniciativas");

        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
        barModel.addSeries(boys);

        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public BarChartModel getBarModel() {
        return barModel;
    }


}
