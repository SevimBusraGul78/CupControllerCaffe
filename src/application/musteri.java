package application;

import java.sql.Date;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class musteri {
    public musteri() {
        // TODO Auto-generated constructor stub
    }
    musteri(int id, String kulad, String islemAciklama, double ucret, Date islem_tarihi) {
        this.id = id;
        this.kul_ad = kulad;
        this.islemAciklama = islemAciklama;
        this.ucret = ucret;
        this.islem_tarihi = islem_tarihi; 
       
    }

    


    private int id;
    private String kul_ad, islemAciklama;

    private Date islem_tarihi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKul_ad() {
        return kul_ad;
    }

    public void setKul_ad(String kul_ad) {
        this.kul_ad = kul_ad;
    }

    public String getIslemAciklama() {
        return islemAciklama;
    }

    public void setIslemAciklama(String islemAciklama) {
        this.islemAciklama = islemAciklama;
    }

    public double getUcret() {
        return ucret;
    }

    public void setUcret(double ucret) {
        this.ucret = ucret;
    }

    public Date getIslem_tarihi() {
        return islem_tarihi;
    }

    public void setIslem_tarihi(Date islem_tarihi) {
        this.islem_tarihi = islem_tarihi;
    }

    private double ucret;
}
