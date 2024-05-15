package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.IsteMYSql.Util.*;
import com.IsteMYSql.*;
import com.IsteMYSql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {
	
	public SampleController() {
		baglanti=VeritabaniUtil.Baglan();
	}
    @FXML
    private Button adminbtngiris;
    
    @FXML
    private TextField admintxtgiriş;

    @FXML
    private Button btngiris;

    @FXML
    private Button btnkayıt;

    @FXML
    private Label lblmüsterigiris;

    @FXML
    private Label lblmüsüterisifre;

    @FXML
    private PasswordField musterigiris;

    @FXML
    private Tab tabadmin;

    @FXML
    private Tab tabmüsteri;

    @FXML
    private TextField txtfieldgiris;

    @FXML
    private TextField txtfieldgiris1;

    @FXML
    private PasswordField txtfieldsifre;

    @FXML
    private Label txtgiris;

    @FXML
    private Label txtsifre;

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
        Connection baglanti = null;
        PreparedStatement sorguİfadesi = null;
      
        String sql;
    @FXML
         void btnkayitol(ActionEvent event) {
    	
    	 String sql = "INSERT INTO login (isim,sifre) VALUES (?, ?)";
         try {
             sorguİfadesi = baglanti.prepareStatement(sql);
             sorguİfadesi.setString(1, txtfieldgiris1.getText().trim());
             sorguİfadesi.setString(2, musterigiris.getText().trim());
             sorguİfadesi.executeUpdate();
             
         } catch (SQLException e) {
            
         }
     }      
    
    @FXML
    void btnmusterigiris(ActionEvent event) {
    	if (MLoginKontrol(txtfieldgiris1.getText(), musterigiris.getText())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menü.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Menü");
                stage.show();

                // İlk sayfayı kapatmak için
                Stage currentStage = (Stage) btngiris.getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
    	        // Sadece hardcoded olarak belirlenmiş bir admin kullanıcı adı ve şifresi ile kontrol yapalım
    	        if (kul.equals("admin") && sifre.equals("pass")) {
    	            return true;
    	        } else {
    	            alert.setContentText("Yanlış kullanıcı adı veya şifre!");
    	            alert.showAndWait();
    	            return false;
    	        } 
    	    }

    }

    
public boolean MLoginKontrol(String Mkul, String Msifre) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("CupControl otomasyonu");
    alert.setHeaderText("Kullanıcı bulunamadı");

    if (Mkul.isEmpty() || Msifre.isEmpty()) {
        alert.setContentText("Kullanıcı adı ve şifre boş bırakılamaz!");
        alert.showAndWait();
        return false;
    } else {
        try {
            String sql = "SELECT * FROM login WHERE isim = ? AND sifre = ?";
            PreparedStatement sorguIfadesi = baglanti.prepareStatement(sql);
            sorguIfadesi.setString(1, Mkul);
            sorguIfadesi.setString(2, Msifre);
            ResultSet sonuc = sorguIfadesi.executeQuery();
            
            if (sonuc.next()) { // Eğer sonuç varsa, yani giriş doğru ise
                return true;
            } else {
                alert.setContentText("Lütfen kayıt olunuz ");
                alert.showAndWait();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

    }

