package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.IsteMYSql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MenüController {
    public MenüController() {
        baglanti = VeritabaniUtil.Baglan();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button siparişVer;

    @FXML
    private Label txtürün;

    @FXML
    private Button btn4;

    @FXML
    private Text txtSonuc;
    @FXML
    private TextField kullaniciadi;

    Connection baglanti = null;
    PreparedStatement sorguİfadesi = null;

    @FXML
    void btn1(ActionEvent event) {
        sepeteEkle(50, "kahve");
    }

    @FXML
    void btn2(ActionEvent event) {
        sepeteEkle(30, "kek");
    }

    @FXML
    void btn3(ActionEvent event) {
        sepeteEkle(40, "pasta");
    }

    @FXML
    void btn4(ActionEvent event) {
        sepeteEkle(20, "kurabiye");
    }

    private void sepeteEkle(double fiyat, String urun) {
        toplamFiyat += fiyat;
        txtSonuc.setText(" " + toplamFiyat);
        urunler += urun + ",";
        txtürün.setText(urunler);
    }
   
    @FXML
    void btnsiparisVer(ActionEvent event) {
        String sql = "INSERT INTO islemler (user,islemAcıklama, islemtutar) VALUES (?, ?,?)";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, kullaniciadi.getText().trim());
            sorguİfadesi.setString(2, txtürün.getText().trim());
            sorguİfadesi.setDouble(3, Double.parseDouble(txtSonuc.getText().trim()));
           
            sorguİfadesi.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Hata mesajını yazdır
        }
    }

    @FXML
    void initialize() {
        // Başlangıç ayarlarını buraya ekle
    }

    private double toplamFiyat = 0.0;
    private String urunler = "";
}
