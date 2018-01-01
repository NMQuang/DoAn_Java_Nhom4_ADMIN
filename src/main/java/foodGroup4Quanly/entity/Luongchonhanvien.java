package foodGroup4Quanly.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "luongchonhanvien")
@IdClass(LuongchonhanvienPK.class)
public class Luongchonhanvien {
    private int nhanVien;
    private String thang;
    private String nam;
    private String moTa;
    private Timestamp ngay;
    private int tien;
    private Nhanvien nhanvien;

    @Id
    @Column(name = "NhanVien")
    public int getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(int nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Id
    @Column(name = "Thang")
    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    @Id
    @Column(name = "Nam")
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @Basic
    @Column(name = "MoTa")
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Basic
    @Column(name ="Ngay")
    @CreationTimestamp
    public Timestamp getNgay() { return ngay; }

    public void setNgay(Timestamp ngay) {
        this.ngay = ngay;
    }

    @Basic
    @Column(name = "Tien")
    public int getTien() { return this.tien; }

    public void setTien(int tien) { this.tien = tien; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Luongchonhanvien that = (Luongchonhanvien) o;

        if (nhanVien != that.nhanVien) return false;
        if (thang != null ? !thang.equals(that.thang) : that.thang != null) return false;
        if (nam != null ? !nam.equals(that.nam) : that.nam != null) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nhanVien;
        result = 31 * result + (thang != null ? thang.hashCode() : 0);
        result = 31 * result + (nam != null ? nam.hashCode() : 0);
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "NhanVien", referencedColumnName = "NhanVienID",
            nullable = false, insertable = false, updatable = false)
    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
}
