package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "khachhang", schema = "java_foodsystem")
public class Khachhang {
    private String sdt;
    private String ten;
    private String cmnd;
    private String password;
    private Date ngayTao;
    private String diaChi;
    private Set<Hoadon> hoadons;

    @Id
    @Column(name = "SDT")
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
    @Column(name = "CMND")
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NgayTao")
    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Khachhang khachhang = (Khachhang) o;

        if (sdt != null ? !sdt.equals(khachhang.sdt) : khachhang.sdt != null) return false;
        if (ten != null ? !ten.equals(khachhang.ten) : khachhang.ten != null) return false;
        if (cmnd != null ? !cmnd.equals(khachhang.cmnd) : khachhang.cmnd != null) return false;
        if (password != null ? !password.equals(khachhang.password) : khachhang.password != null) return false;
        if (ngayTao != null ? !ngayTao.equals(khachhang.ngayTao) : khachhang.ngayTao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sdt != null ? sdt.hashCode() : 0;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (cmnd != null ? cmnd.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (ngayTao != null ? ngayTao.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "khachhang")
    public Set<Hoadon> getHoadons() {
        return hoadons;
    }

    public void setHoadons(Set<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }
}
