package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tienthuenha", schema = "java_foodsystem")
@IdClass(TienthuenhaPK.class)
public class Tienthuenha {
    private String thang;
    private String nam;
    private String ten;
    private String moTa;
    private Date ngayChi;
    private Chinhanh chinhanh;

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

    @Basic
    @Column(name = "NgayChi")
    public Date getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tienthuenha that = (Tienthuenha) o;

        if (thang != null ? !thang.equals(that.thang) : that.thang != null) return false;
        if (nam != null ? !nam.equals(that.nam) : that.nam != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;
        if (ngayChi != null ? !ngayChi.equals(that.ngayChi) : that.ngayChi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = thang != null ? thang.hashCode() : 0;
        result = 31 * result + (nam != null ? nam.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        result = 31 * result + (ngayChi != null ? ngayChi.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ChiNhanh", referencedColumnName = "ChiNhanhID", nullable = false)
    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }
}
