package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.IsteMYSql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenüController {

    public MenüController() {
        baglanti = VeritabaniUtil.Baglan();
    }

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private Text txt1;

    @FXML
    private Text txt2;

    @FXML
    private Text txt3;

    @FXML
    private Text txt4;


    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
    

    @FXML
    private Label txtürün;

    @FXML
    private Button siparişVer;

    @FXML
    private Text kurabiyefiyatı;

    @FXML
    private Text pastafiyatı;
    @FXML
    private Text kahvefiyatı;

    @FXML
    private Text kekfiyatı;
    
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
        txt1.setText("kahve");
        kahvefiyatı.setText("50");
        
    }

   
	@FXML
    void btn2(ActionEvent event) {
        sepeteEkle(30, "kek");
        txt2.setText("kek");
        kekfiyatı.setText("30");
    }

    @FXML
    void btn3(ActionEvent event) {
        sepeteEkle(40, "pasta");
        txt3.setText("pasta");
        pastafiyatı.setText("40");
    }

    @FXML
    void btn4(ActionEvent event) {
        sepeteEkle(20, "kurabiye");
        txt4.setText("kurabiye");
        kurabiyefiyatı.setText("20");
    }

    private void sepeteEkle(double fiyat, String urun) {
        toplamFiyat += fiyat;
        txtSonuc.setText(" " + toplamFiyat);
        urunler += urun + "\n\n\n\n";
        txtürün.setText(urunler);
    }

    @FXML
    void btnsiparisVer(ActionEvent event) {
        String sql = "INSERT INTO islemler (user, islemAcıklama, islemtutar) VALUES (?, ?, ?)";
        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            sorguİfadesi.setString(1, kullaniciadi.getText().trim());
            sorguİfadesi.setString(2, txtürün.getText().trim());
            sorguİfadesi.setDouble(3, Double.parseDouble(txtSonuc.getText().trim()));

            sorguİfadesi.executeUpdate();

            // Yeni bir pencere aç
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fiş.fxml")); // YeniSayfa.fxml'yi yükleyin
            Parent root = loader.load(); // Yüklenen FXML'i bir ebeveyn düğüm olarak yükleyin
            Stage stage = new Stage(); // Yeni bir sahne oluşturun
            stage.setScene(new Scene(root)); // Sahneye kökü ayarlayın
            stage.show(); // Pencereyi göster
            
            // txtisim TextField'ının değerini alarak yeni açılan pencereye aktarım işlemi
            fişController fişController = loader.getController();
            fişController.getTxtisim().setText(kullaniciadi.getText().trim());
            fişController.getÜrün1().setText(txt1.getText().trim());
            fişController.getÜrün2().setText(txt2.getText().trim());
            fişController.getÜrün3().setText(txt3.getText().trim());
            fişController.getÜrün4().setText(txt4.getText().trim());
            fişController.getToplamfiyat().setText(txtSonuc.getText().trim());
            fişController.getFiyat1().setText(kahvefiyatı.getText().trim());
            fişController.getFiyat2().setText(kekfiyatı.getText().trim());
            fişController.getFiyat3().setText(kurabiyefiyatı.getText().trim());
            fişController.getFiyat4().setText(pastafiyatı.getText().trim());

        } catch (SQLException | IOException e) {
            e.printStackTrace(); // Hata mesajını yazdır
        }
    }

    @FXML
    void initialize() {
        // Başlangıç ayarlarını buraya ekle
    }

    private double toplamFiyat = 0.0;
    private String urunler = "";

    // TextFieldDegeriAlmaSınıfı iç içe sınıf olarak değil, ayrı bir dosyada bulunabilir.
    // Ancak iç içe sınıf olarak kullanılacaksa MenüController sınıfının içinde değil, dışında tanımlanmalıdır.
   
}