package foodGroup4Quanly.dto;

import java.io.Serializable;
import java.util.Date;

public class TongLuongNhanVienTheoThangDto implements Serializable {
    private String thang;
    private String nam;
    private Date ngayChi;
    private long tongTien;

    public TongLuongNhanVienTheoThangDto() {
    }

    public TongLuongNhanVienTheoThangDto(String thang, String nam, Date ngayChi, long tongTien) {
        this.thang = thang;
        this.nam = nam;
        this.ngayChi = ngayChi;
        this.tongTien = tongTien;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }
}
