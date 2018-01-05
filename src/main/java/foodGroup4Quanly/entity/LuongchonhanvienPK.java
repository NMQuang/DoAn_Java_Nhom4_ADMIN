package foodGroup4Quanly.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LuongchonhanvienPK implements Serializable {
    private int nhanVien;
    private String thang;
    private String nam;

    public LuongchonhanvienPK() {

    }

    public LuongchonhanvienPK(int nhanVien, String thang, String nam) {
        this.nhanVien = nhanVien;
        this.thang = thang;
        this.nam = nam;
    }

    @Column(name = "NhanVien")
    @Id
    public int getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(int nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Column(name = "Thang")
    @Id
    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    @Column(name = "Nam")
    @Id
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LuongchonhanvienPK that = (LuongchonhanvienPK) o;

        if (nhanVien != that.nhanVien) return false;
        if (thang != null ? !thang.equals(that.thang) : that.thang != null) return false;
        if (nam != null ? !nam.equals(that.nam) : that.nam != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nhanVien;
        result = 31 * result + (thang != null ? thang.hashCode() : 0);
        result = 31 * result + (nam != null ? nam.hashCode() : 0);
        return result;
    }
}
