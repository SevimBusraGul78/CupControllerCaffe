package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminbtngiris;

    @FXML
    private Label lblmüsterigiris;

    @FXML
    private Label lblmüsüterisifre;

    @FXML
    private Tab tabadmin;

    @FXML
    private Tab tabmüsteri;

    @FXML
    private TextField admintxtgiriş;

    @FXML
    private TextField txtfieldsifre;

    @FXML
    private Label txtgiris;

    @FXML
    private Label txtsifre;

    @FXML
    void btnalert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bilgi Mesajıdır ....... ");
        alert.setHeaderText("Bu kodu yazan kız mükemmeldir");
        alert.setContentText("Bilgilendirme Bitmiştir....\n by Sevim Büşra ");
        alert.showAndWait();
    }

    @FXML
    void btnadmingiris(ActionEvent event) {
        if (LoginKontrol(admintxtgiriş.getText(), txtfieldsifre.getText())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ikincisayfa.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("İkinci Sayfa");
                stage.show();

                // İlk sayfayı kapatmak için
                Stage currentStage = (Stage) adminbtngiris.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnkayitol(ActionEvent event) {
        // Buraya kayıt olma işlemleri eklenebilir.
    }

    @FXML
    void btnmusterigiris(ActionEvent event) {
        // Buraya müşteri giriş işlemleri eklenebilir.
    }

    @FXML
    void initialize() {
        // Başlangıç ayarlamaları burada yapılabilir.
    }

    public boolean LoginKontrol(String kul, String sifre) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("CupControl otomasyonu");
        alert.setHeaderText("Kullanıcı adını veya Şifreni kontrol et ");

        if (kul.isEmpty() || sifre.isEmpty()) {
            alert.setContentText("Kullanıcı adı ve şifre boş bırakılamaz!");
            alert.showAndWait();
            return false;
        } else {
            // Kullanıcı adı ve şifreyi kontrol et
            if (kul.equals("admin") && sifre.equals("pass")) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CupControl otomasyonu");
                alert.setHeaderText(null);
                alert.setContentText("Doğru giriş!");
                alert.showAndWait();
                return true;
            } else {
                alert.setContentText("Yanlış kullanıcı adı veya şifre!");
                alert.showAndWait();
                return false;
            }
        }
    }
}
