package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class ucuncuadmin {

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
        private Button btnsil;

        @FXML
        void btnekle(ActionEvent event) {

        }

        @FXML
        void btngüncelle(ActionEvent event) {

        }

        @FXML
        void btnsil(ActionEvent event) {

        }

        @FXML
        void initialize() {
            assert btnekle != null : "fx:id=\"btnekle\" was not injected: check your FXML file 'ucuncuAdmin.fxml'.";
            assert btngüncelle != null : "fx:id=\"btngüncelle\" was not injected: check your FXML file 'ucuncuAdmin.fxml'.";
            assert btnsil != null : "fx:id=\"btnsil\" was not injected: check your FXML file 'ucuncuAdmin.fxml'.";

        }

    }

    
    

