package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "nhanvien",  schema = "java_foodsystem")
public class Nhanvien {
    private int nhanVienId;
    private String ten;
    private Date ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private String sdt;
    private String diaChi;
    private int luong;
    private Set<AccountAdmin> accountAdmins;
    private Set<Hoadon> hoadons;
    private Luongchonhanvien luongchonhanvien;
    private Chinhanh chinhanh;
    private Chucvu chucvu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NhanVienID")
    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
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
    @Column(name = "NgaySinh")
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "GioiTinh")
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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
    @Column(name = "SDT")
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
    @Column(name = "Luong")
    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nhanvien nhanvien = (Nhanvien) o;

        if (nhanVienId != nhanvien.nhanVienId) return false;
        if (luong != nhanvien.luong) return false;
        if (ten != null ? !ten.equals(nhanvien.ten) : nhanvien.ten != null) return false;
        if (ngaySinh != null ? !ngaySinh.equals(nhanvien.ngaySinh) : nhanvien.ngaySinh != null) return false;
        if (gioiTinh != null ? !gioiTinh.equals(nhanvien.gioiTinh) : nhanvien.gioiTinh != null) return false;
        if (cmnd != null ? !cmnd.equals(nhanvien.cmnd) : nhanvien.cmnd != null) return false;
        if (sdt != null ? !sdt.equals(nhanvien.sdt) : nhanvien.sdt != null) return false;
        if (diaChi != null ? !diaChi.equals(nhanvien.diaChi) : nhanvien.diaChi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nhanVienId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (ngaySinh != null ? ngaySinh.hashCode() : 0);
        result = 31 * result + (gioiTinh != null ? gioiTinh.hashCode() : 0);
        result = 31 * result + (cmnd != null ? cmnd.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + luong;
        return result;
    }

    @OneToMany(mappedBy = "nhanvien")
    public Set<AccountAdmin> getAccountAdmins() {
        return accountAdmins;
    }

    public void setAccountAdmins(Set<AccountAdmin> accountAdmins) {
        this.accountAdmins = accountAdmins;
    }

    @OneToMany(mappedBy = "nhanvien")
    public Set<Hoadon> getHoadons() {
        return hoadons;
    }

    public void setHoadons(Set<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }

    @OneToOne(mappedBy = "nhanvien")
    public Luongchonhanvien getLuongchonhanvien() {
        return luongchonhanvien;
    }

    public void setLuongchonhanvien(Luongchonhanvien luongchonhanvien) {
        this.luongchonhanvien = luongchonhanvien;
    }

    @ManyToOne
    @JoinColumn(name = "ChiNhanh", referencedColumnName = "ChiNhanhID", nullable = false)
    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    @ManyToOne
    @JoinColumn(name = "ChucVu", referencedColumnName = "ChucVuID", nullable = false)
    public Chucvu getChucvu() {
        return chucvu;
    }

    public void setChucvu(Chucvu chucvu) {
        this.chucvu = chucvu;
    }
}
