package foodGroup4Quanly.dto;

import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.entity.Tienthuenha;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TienThueNhaDto {
    private String thoiGian;
    private String ten;
    private String mota;
    private Integer tien;

    public Tienthuenha getTienThueNha() {
        // not valid
        Date date = Utils.parseDate(this.thoiGian, "MM-yyyy");
        if(date == null) return null;

        Tienthuenha tienthuenha = new Tienthuenha();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String strMonth = String.format("%02d", cal.get(Calendar.MONTH) + 1);
        String strYear = String.format("%04d", cal.get(Calendar.YEAR));

        tienthuenha.setThang(strMonth);
        tienthuenha.setNam(strYear);
        tienthuenha.setTen(this.ten);
        tienthuenha.setMoTa(this.mota);
        tienthuenha.setNgayChi(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        tienthuenha.setTien(this.tien);
        tienthuenha.setChinhanh(Utils.getChinhanhHienTai());

        return tienthuenha;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
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
