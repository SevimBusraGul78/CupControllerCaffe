package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
;

public class ürüngrafiğiController { // Updated class name according to Java naming conventions

   // Updated variable name to follow camelCase convention
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
	@FXML
	private PieChart ürünGrafiği;
    @FXML
    void initialize() {
        // Veri oluştur
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Java", 40),
                new PieChart.Data("Python", 30),
                new PieChart.Data("C++", 20),
                new PieChart.Data("JavaScript", 10)
        );

        // Pasta grafik tablosu oluştur
        ürünGrafiği.setTitle("Programlama Dilleri Dağılımı");
        ürünGrafiği.setData(pieChartData);
    }
}

