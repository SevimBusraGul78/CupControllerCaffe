package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.IsteMYSql.Util.VeritabaniUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
;

public class ürüngrafiğiController { // Updated class name according to Java naming conventions
	public ürüngrafiğiController() {
		baglanti=VeritabaniUtil.Baglan();
	}

   // Updated variable name to follow camelCase convention
	@FXML
    private ResourceBundle resources;
	
    @FXML
    private ImageView img2;
    @FXML
    private Button geri;
    @FXML
    private ImageView imageView;
    @FXML
    private URL location;
	@FXML
	private PieChart ürünGrafiği;
	
	 Connection baglanti = null;
     PreparedStatement sorguİfadesi = null;
     ResultSet getirilen = null;
     String sql;
	
     @FXML
     void btngeri(ActionEvent event) {
    	 try {
             // Üçüncü sayfanın FXML dosyasını yükle
             Parent root = FXMLLoader.load(getClass().getResource("ikincisayfa.fxml"));
             Scene scene = new Scene(root);
             
             // Stage'i al
             Stage stage = (Stage) geri.getScene().getWindow();
             stage.setTitle("Admin Sayfası");
             // Yeni sahneyi göster
             stage.setScene(scene);
             stage.show();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
     
    @FXML
    void initialize() {
    	  ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
          try {
              String sql = "SELECT COUNT(*) FROM login"; // Kişi sayısını say
              sorguİfadesi = baglanti.prepareStatement(sql);
              getirilen = sorguİfadesi.executeQuery();
              if (getirilen.next()) {
                  int toplamKisiSayisi = getirilen.getInt(1);
                  int doluKoltukSayisi = Math.min(toplamKisiSayisi, 10);
                  int bosKoltukSayisi = 10 - doluKoltukSayisi;
                  int rezerveSayisi=2;
                  pieChartData.addAll(new PieChart.Data("Dolu", doluKoltukSayisi),
                                      new PieChart.Data("Boş", bosKoltukSayisi),
                                      new PieChart.Data("rezerve",rezerveSayisi)           
                		  );
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (getirilen != null) getirilen.close();
                  if (sorguİfadesi != null) sorguİfadesi.close();
                  if (baglanti != null) baglanti.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }

          // Pasta grafiği tablosunu oluştur
          ürünGrafiği.setTitle("CupControllerCaffe Otomasyonu Doluluk Oranı");
          ürünGrafiği.setData(pieChartData);
      }}