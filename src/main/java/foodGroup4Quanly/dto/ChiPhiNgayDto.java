package foodGroup4Quanly.dto;

import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.entity.Chiphingay;

public class ChiPhiNgayDto {
    private String ten;
    private String mota;
    private Integer tien;

    public Chiphingay getChiPhiNgay() {
        Chiphingay chiphingay = new Chiphingay();
        chiphingay.setTen(this.ten);
        chiphingay.setMoTa(this.mota);
        chiphingay.setTien(this.tien);
        chiphingay.setChinhanh(Utils.getChinhanhHienTai());
        return chiphingay;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getTien() {
        return tien;
    }

    public void setTien(Integer tien) {
        this.tien = tien;
    }
}
