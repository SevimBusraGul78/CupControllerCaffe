package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ikinciSayfa {

    @FXML
    private Button btnboş;

    @FXML
    private Button btnmusteri;

    @FXML
    private Button btnstok;

    @FXML
    void btnBos(ActionEvent event) {
        // Boş butona tıklanınca yapılacak işlemler
    }

    @FXML
    void btnMusteri(ActionEvent event) {
        // Müşteri butonuna tıklanınca yapılacak işlemler
    }

    @FXML
    void btnStok(ActionEvent event) {
    	  try {
              // Üçüncü sayfanın FXML dosyasını yükle
              Parent root = FXMLLoader.load(getClass().getResource("ucuncuAdmin.fxml"));
              Scene scene = new Scene(root);
              
              // Stage'i al
              Stage stage = (Stage) btnstok.getScene().getWindow();
              
              // Yeni sahneyi göster
              stage.setScene(scene);
              stage.show();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      
    
@FXML
void initialize() {
    // Başlangıç ayarlamaları burada yapılabilir.
}

}