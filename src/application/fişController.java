package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.MenüController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class fişController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
	private Text txtisim;
    @FXML
    private Text fiyat1;

    @FXML
    private Text fiyat2;

    @FXML
    private Text fiyat3;

    @FXML
    private Text fiyat4;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private Text toplam;

    @FXML
    private Text toplamfiyat;

    @FXML
    private Text ürün1;

    public Text getFiyat1() {
		return fiyat1;
	}

	public void setFiyat1(Text fiyat1) {
		this.fiyat1 = fiyat1;
	}

	public Text getFiyat2() {
		return fiyat2;
	}

	public void setFiyat2(Text fiyat2) {
		this.fiyat2 = fiyat2;
	}

	public Text getFiyat3() {
		return fiyat3;
	}

	public void setFiyat3(Text fiyat3) {
		this.fiyat3 = fiyat3;
	}

	public Text getFiyat4() {
		return fiyat4;
	}

	public void setFiyat4(Text fiyat4) {
		this.fiyat4 = fiyat4;
	}

	public Text getÜrün1() {
		return ürün1;
	}

	public void setÜrün1(Text ürün1) {
		this.ürün1 = ürün1;
	}

	public Text getÜrün2() {
		return ürün2;
	}

	public void setÜrün2(Text ürün2) {
		this.ürün2 = ürün2;
	}

	public Text getÜrün3() {
		return ürün3;
	}

	public void setÜrün3(Text ürün3) {
		this.ürün3 = ürün3;
	}

	public Text getÜrün4() {
		return ürün4;
	}

	public void setÜrün4(Text ürün4) {
		this.ürün4 = ürün4;
	}

	@FXML
    private Text ürün2;

    @FXML
    private Text ürün3;

    @FXML
    private Text ürün4;

    public class TextFieldDegeriAlmaSınıfı {
        public void textFieldDegeriniAl(String deger) {
            Text text = new Text();
			// FişController sınıfındaki txtisim TextField'ına değişken değerini aktarır
            text.setText(deger);
        }
    }
   
    @FXML
    void initialize() {
    
    	}

	public Text getToplamfiyat() {
		return toplamfiyat;
	}

	public void setToplamfiyat(Text toplamfiyat) {
		this.toplamfiyat = toplamfiyat;
	}

	public Text getTxtisim() {
		return txtisim;
	}

	public void setTxtisim(Text txtisim) {
		this.txtisim = txtisim;
	}


    }


