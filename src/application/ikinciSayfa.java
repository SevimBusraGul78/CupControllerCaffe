package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ikinciSayfa {

    @FXML
    private Label labelInfo;

    @FXML
    void btnKapatClick(ActionEvent event) {
        // Butona tıklanınca ikinci sayfayı kapat
        Stage stage = (Stage) labelInfo.getScene().getWindow();
        stage.close();
    }

    public void setInfoText(String text) {
        labelInfo.setText(text);
    }
}
 