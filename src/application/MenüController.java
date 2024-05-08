package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.IsteMYSql.Util.VeritabaniUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MenüController {
	public MenüController() {
		baglanti=VeritabaniUtil.Baglan();
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
    private Button btn4;
    
    private double toplamFiyat = 0.0;

    @FXML
    private Text txtSonuc;
   
  
   Connection baglanti = null;
   PreparedStatement sorguİfadesi = null;
   ResultSet getirilen = null;
   String sql;
   
    
    @FXML
    void btn1(ActionEvent event) {
    	 sepeteEkle(50);
    	
    }

    @FXML
    void btn2(ActionEvent event) {
    	sepeteEkle(30);
    }

    @FXML
    void btn3(ActionEvent event) {
    	  sepeteEkle(40);
    	
    }

    @FXML
    void btn4(ActionEvent event) {
    	 sepeteEkle(20);
    }

    private void sepeteEkle(double fiyat) {
        toplamFiyat += fiyat;
        txtSonuc.setText(" " + toplamFiyat);
    }
    @FXML
    void btnsiparisVer(ActionEvent event) {
    	 String sql = "INSERT INTO islemler (iID,user,islemAcıklama,islemtutar) VALUES (?, ?, ?,?)";
         try {
             sorguİfadesi = baglanti.prepareStatement(sql);
             sorguİfadesi.setString(1, btn1.getText().trim());
             sorguİfadesi.setString(2, btn2.getText().trim());
             sorguİfadesi.setString(3, btn3.getText().trim());
             sorguİfadesi.setString(4, btn4.getText().trim());
             sorguİfadesi.executeUpdate();
             
         } catch (SQLException e) {
            // lbluyarı.setText("Hata: " + e.getMessage());
         }
     }      
    
    @FXML
    void initialize() {
       

    }

}
