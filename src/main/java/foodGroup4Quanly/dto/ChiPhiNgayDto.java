package foodGroup4Quanly.dto;

import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.entity.Chiphingay;

public class ChiPhiNgayDto {
    private String ten;
    private String mota;
    private Integer tien;

    public ChiPhiNgayDto() {

    }

    public ChiPhiNgayDto(Chiphingay chiphingay) {
        this.ten = chiphingay.getTen();
        this.mota = chiphingay.getMoTa();
        this.tien = chiphingay.getTien();
    }

    public Chiphingay getChiPhiNgay() {
        Chiphingay chiphingay = new Chiphingay();
        chiphingay = this.tranferDataToChiPhiNgay(chiphingay);
        chiphingay.setChinhanh(Utils.getChinhanhHienTai());
        return chiphingay;
    }

    public Chiphingay tranferDataToChiPhiNgay(Chiphingay chiphingay) {
        chiphingay.setTen(this.ten);
        chiphingay.setMoTa(this.mota);
        chiphingay.setTien(this.tien);

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
