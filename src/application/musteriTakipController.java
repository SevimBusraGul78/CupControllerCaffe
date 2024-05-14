package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import java.sql.*;
import com.IsteMYSql.Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class musteriTakipController {
public musteriTakipController() {
	baglanti=VeritabaniUtil.Baglan();
}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private TextField txt_arama;

    @FXML
    private TableView<musteri> TableView_Aramalar;

    @FXML
    private Button btnsorgula;

    @FXML
    private TableColumn<musteri, String> columnAçıklmaa;

    @FXML
    private TableColumn<musteri, Integer> columnID;

    @FXML
    private TableColumn<musteri, String> columnKulAdı;

    @FXML
    private TableColumn<musteri, LocalDate> columnTarih;

    @FXML
    private TableColumn<musteri, Double> columnTutar;

    @FXML
    private ComboBox<String> combouser;

    @FXML
    private DatePicker dateBaslangıc;

    @FXML
    private DatePicker datebitis;

   
    
    Connection baglanti = null;
    PreparedStatement sorguİfadesi = null;
    ResultSet getirilen = null;
    String sql;
    

    @FXML
    void btnsorgula(ActionEvent event) {
    	 sql="select * from islemler where islemTarihi > '"+dateBaslangıc.getValue()+"' and islemTarihi <'"+datebitis.getValue()+"'" ;

      DegerleriGetir(TableView_Aramalar, sql);
    }

    @FXML
    void combouser(ActionEvent event) {

    }

    @FXML
    void txt_arama_KeyPressed(KeyEvent event) {
    	 if (txt_arama.getText().equals("")) {
    	        sql = "select * from islemler";
    	    } else {
    	        sql = "select * from islemler where islemAcıklama like '%" + txt_arama.getText() + "%' or user like '%" + txt_arama.getText() + "%'";
    	    }
    	    DegerleriGetir(TableView_Aramalar, sql);
    	}

    @FXML
    void txt_arama_action(ActionEvent event) {

    }

    public void DegerleriGetir(TableView<musteri> tablo, String sql) {
    	  ObservableList<musteri> kayıtlarListe = FXCollections.observableArrayList();

    	    try {
    	        sorguİfadesi = baglanti.prepareStatement(sql);
    	        ResultSet getirilen = sorguİfadesi.executeQuery();
    	        while (getirilen.next()) {
    	            LocalDate islemTarihi = null;
    	            Date date = getirilen.getDate("islemTarihi");
    	            if (date != null) {
    	                islemTarihi = date.toLocalDate();
    	            }
    	            kayıtlarListe.add(new musteri( 
    	                getirilen.getInt("iId"),
    	                getirilen.getString("user"),
    	                getirilen.getString("islemAcıklama"),
    	                getirilen.getDouble("islemtutar"),
    	                islemTarihi)); // Convert SQL Date to LocalDate
    	        }
    	        // Set cell value factories
    	        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
    	        columnKulAdı.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
    	        columnAçıklmaa.setCellValueFactory(new PropertyValueFactory<>("islemAciklama"));
    	        columnTutar.setCellValueFactory(new PropertyValueFactory<>("ucret"));
    	        columnTarih.setCellValueFactory(new PropertyValueFactory<>("islem_tarihi"));

    	        TableView_Aramalar.setItems(kayıtlarListe);
    	    } catch (SQLException e) {
    	        System.out.println(e.getMessage().toString());
    	    } finally {
    	        try {
    	            if (getirilen != null) getirilen.close();
    	            if (sorguİfadesi != null) sorguİfadesi.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	}


    
    
    @FXML
    void initialize() {
    	sql="select * from islemler";
      DegerleriGetir(TableView_Aramalar, sql);
      
      dateBaslangıc.setValue(LocalDate.now());
      datebitis.setValue(LocalDate.now());

    }

}

