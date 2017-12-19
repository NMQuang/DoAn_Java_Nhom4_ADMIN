package foodGroup4Quanly.entity;

import javax.persistence.*;

@Entity
@Table(name = "luongchonhanvien")
@IdClass(LuongchonhanvienPK.class)
public class Luongchonhanvien {
    private int nhanVien;
    private String thang;
    private String nam;
    private String diaChi;
    private String ten;
    private String moTa;
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
    @Column(name = "DiaChi")
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "Ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "MoTa")
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Luongchonhanvien that = (Luongchonhanvien) o;

        if (nhanVien != that.nhanVien) return false;
        if (thang != null ? !thang.equals(that.thang) : that.thang != null) return false;
        if (nam != null ? !nam.equals(that.nam) : that.nam != null) return false;
        if (diaChi != null ? !diaChi.equals(that.diaChi) : that.diaChi != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nhanVien;
        result = 31 * result + (thang != null ? thang.hashCode() : 0);
        result = 31 * result + (nam != null ? nam.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
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
