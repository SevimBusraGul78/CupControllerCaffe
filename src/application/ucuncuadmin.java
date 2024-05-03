package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.IsteMYSql.Util.*;
import com.IsteMYSql.*;
import javafx.scene.control.TableColumn;


      public class ucuncuadmin {
	public  ucuncuadmin() {
		baglanti=VeritabaniUtil.Baglan();
	}
    @FXML
    private Label labelInfo;

    @FXML
    void btnKapatClick(ActionEvent event) {
        // Butona tıklanınca üçüncü sayfayı kapat
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ucuncuAdmin.fxml"));
        Stage stage = (Stage) labelInfo.getScene().getWindow();
        stage.close();
    }
    public void setInfoText(String text) {
        labelInfo.setText(text);
    }
        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button btnekle;

        @FXML
        private Button btngüncelle;
        
        @FXML
        private TableView<StokTakibi> TableColumn;
        
        @FXML
        private TableColumn<StokTakibi,Integer> columnKahve;

        @FXML
        private TableColumn<StokTakibi,Integer> columnKek;

        @FXML
        private TableColumn<StokTakibi,Integer> columnKurabiye;

        @FXML
        private TableColumn<StokTakibi,Integer> columnPasta;

        @FXML
        private Button btnsil;
        @FXML
        private TextField txtKahve;

        @FXML
        private TextField txtKek;

        @FXML
        private TextField txtKurabiye;
        
        @FXML
        private Label lbluyarı;
        

       
        @FXML
        void TableViewMouseClicked(MouseEvent event) {
            StokTakibi kayitlar = TableColumn.getSelectionModel().getSelectedItem();
            if (kayitlar != null) {
                txtKahve.setPromptText(String.valueOf(kayitlar.getKahve()));
                txtKek.setPromptText(String.valueOf(kayitlar.getKek()));
                txtPasta.setPromptText(String.valueOf(kayitlar.getPasta()));
                txtKurabiye.setPromptText(String.valueOf(kayitlar.getKurabiye()));
            }
        }

        @FXML
        private TextField txtPasta;
        
        Connection baglanti = null;
        PreparedStatement sorguİfadesi = null;
        ResultSet getirilen = null;
        String sql;
        
       
        public void DegerleriGetir(TableView tablo) {
       	 sql="select * from stoktakibi";
       	ObservableList<StokTakibi> kayıtlarListe=FXCollections.observableArrayList();
       	
       	try {
       		sorguİfadesi=baglanti.prepareStatement(sql);
       		ResultSet getirilen=sorguİfadesi.executeQuery();
       		while (getirilen.next()) {
   				kayıtlarListe.add(new StokTakibi(getirilen.getInt("Kahve"), getirilen.getInt("Kek"), getirilen.getInt("Pasta"), getirilen.getInt("Kurabiye")));
   				
   			}
       		
       		columnKahve.setCellValueFactory(new PropertyValueFactory<>("Kahve"));
       		columnKek.setCellValueFactory(new PropertyValueFactory<>("Kek"));
       		columnPasta.setCellValueFactory(new PropertyValueFactory<>("Pasta"));
       		columnKurabiye.setCellValueFactory(new PropertyValueFactory<>("Kurabiye"));
   		     TableColumn.setItems(kayıtlarListe);
       	}  
    
       	catch (Exception e) {
   			System.out.println(e.getMessage().toString());
   		}
       }
      
        @FXML
        void btnekle(ActionEvent event) {
        	 String sql = "INSERT INTO stoktakibi (Kahve,Kek,Pasta,Kurabiye) VALUES (?, ?, ?,?)";
             try {
                 sorguİfadesi = baglanti.prepareStatement(sql);
                 sorguİfadesi.setString(1, txtKahve.getText().trim());
                 sorguİfadesi.setString(2, txtKek.getText().trim());
                 sorguİfadesi.setString(3, txtPasta.getText().trim());
                 sorguİfadesi.setString(4, txtKurabiye.getText().trim());
                 sorguİfadesi.executeUpdate();
                 lbluyarı.setText("Kullanıcı ekleme gerçekleşti...");
             } catch (SQLException e) {
                 lbluyarı.setText("Hata: " + e.getMessage());
             }
         }      
        @FXML
        void btngüncelle(ActionEvent event) {
        	DegerleriGetir(TableColumn);
        }

        @FXML
        void btnsil(ActionEvent event) {
        	 String sql = "DELETE FROM stoktakibi WHERE Kahve=? and Kek=? and Pasta=? and Kurabiye=?";
             try {
            	 sorguİfadesi = baglanti.prepareStatement(sql);
                 sorguİfadesi.setString(1, txtKahve.getText().trim());
                 sorguİfadesi.setString(2, txtKek.getText().trim());
                 sorguİfadesi.setString(3, txtPasta.getText().trim());
                 sorguİfadesi.setString(4, txtKurabiye.getText().trim());
                 sorguİfadesi.executeUpdate();
                 lbluyarı.setText("Kullanıcı silme işlemi gerçekleşti...");
             } catch (SQLException e) {
                 lbluyarı.setText("Hata: " + e.getMessage());
             }
         }
        

        @FXML
        void initialize() {
        	 DegerleriGetir(TableColumn);
        }

    }

    
    

