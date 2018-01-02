package foodGroup4Quanly.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "chiphingay", schema = "java_foodsystem", catalog = "")
public class Chiphingay {
    private int chiPhiNgayId;
    private String ten;
    private String moTa;
    private Timestamp ngay;
    private int tien;
    private Chinhanh chinhanh;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChiPhiNgayID")
    public int getChiPhiNgayId() {
        return chiPhiNgayId;
    }

    public void setChiPhiNgayId(int chiPhiNgayId) {
        this.chiPhiNgayId = chiPhiNgayId;
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
    @Column(name = "Ngay")
    @CreationTimestamp
    public Timestamp getNgay() {
        return ngay;
    }

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

        Chiphingay that = (Chiphingay) o;

        if (chiPhiNgayId != that.chiPhiNgayId) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;
        if (ngay != null ? !ngay.equals(that.ngay) : that.ngay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chiPhiNgayId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        result = 31 * result + (ngay != null ? ngay.hashCode() : 0);
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
