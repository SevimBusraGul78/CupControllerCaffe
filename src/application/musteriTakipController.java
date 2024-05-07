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


public class musteriTakipController {
public musteriTakipController() {
	baglanti=VeritabaniUtil.Baglan();
}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private TableColumn<musteri, DatePicker> columnTarih;

    @FXML
    private TableColumn<musteri, Double> columnTutar;

    @FXML
    private ComboBox<String> combouser;

    @FXML
    private DatePicker dateBaslangıc;

    @FXML
    private DatePicker datebitis;

    @FXML
    private TextField txt_id;
    
    Connection baglanti = null;
    PreparedStatement sorguİfadesi = null;
    ResultSet getirilen = null;
    String sql;
    

    @FXML
    void btnsorgula(ActionEvent event) {

    }

    @FXML
    void combouser(ActionEvent event) {

    }

    @FXML
    void txt_arama_KeyPressed(KeyEvent event) {

    }

    @FXML
    void txt_arama_action(ActionEvent event) {

    }

    public void DegerleriGetir(TableView<musteri> tablo, String sql) {
        sql = "select * from islemler";
        ObservableList<musteri> kayıtlarListe = FXCollections.observableArrayList();

        try {
            sorguİfadesi = baglanti.prepareStatement(sql);
            ResultSet getirilen = sorguİfadesi.executeQuery();
            while (getirilen.next()) {
                kayıtlarListe.add(new musteri(
                        getirilen.getInt("iId"),
                        getirilen.getString("user"),
                        getirilen.getString("islemAcıklama"),
                        getirilen.getDouble("islemtutar"),
                        getirilen.getDate("islemTarihi")));
            }
            columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnKulAdı.setCellValueFactory(new PropertyValueFactory<>("kul_ad"));
            columnAçıklmaa.setCellValueFactory(new PropertyValueFactory<>("islemAciklama"));
            columnTutar.setCellValueFactory(new PropertyValueFactory<>("ucret"));
            columnTarih.setCellValueFactory(new PropertyValueFactory<>("islem_tarihi"));

            tablo.setItems(kayıtlarListe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    
    @FXML
    void initialize() {
    	sql="select * from islemler";
      DegerleriGetir(TableView_Aramalar, sql);

    }

}

