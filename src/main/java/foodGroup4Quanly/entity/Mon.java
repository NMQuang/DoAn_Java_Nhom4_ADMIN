package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mon", schema = "java_foodsystem", catalog = "")
public class Mon {
    private int monId;
    private String ten;
    private String donViTinh;
    private String moTa;
    private String hinhAnh;
    private int soLuongDaBan;
    private boolean active;
    private Set<Chinhanhmon> chinhanhmons;
    private Set<Chitiethoadon> chitiethoadons;
    private Danhmuc danhmuc;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MonID")
    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
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
    @Column(name = "DonViTinh")
    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
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
    @Column(name = "HinhAnh")
    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Basic
    @Column(name = "SoLuongDaBan")
    public int getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(int soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    @Basic
    @Column(name = "Active")
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mon mon = (Mon) o;

        if (monId != mon.monId) return false;
        if (soLuongDaBan != mon.soLuongDaBan) return false;
        if (ten != null ? !ten.equals(mon.ten) : mon.ten != null) return false;
        if (donViTinh != null ? !donViTinh.equals(mon.donViTinh) : mon.donViTinh != null) return false;
        if (moTa != null ? !moTa.equals(mon.moTa) : mon.moTa != null) return false;
        if (hinhAnh != null ? !hinhAnh.equals(mon.hinhAnh) : mon.hinhAnh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = monId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (donViTinh != null ? donViTinh.hashCode() : 0);
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        result = 31 * result + (hinhAnh != null ? hinhAnh.hashCode() : 0);
        result = 31 * result + soLuongDaBan;
        return result;
    }

    @OneToMany(mappedBy = "pk.mon", cascade = CascadeType.ALL)
    public Set<Chinhanhmon> getChinhanhmons() {
        return chinhanhmons;
    }

    public void setChinhanhmons(Set<Chinhanhmon> chinhanhmons) {
        this.chinhanhmons = chinhanhmons;
    }

    @OneToMany(mappedBy = "pk.mon")
    public Set<Chitiethoadon> getChitiethoadons() {
        return chitiethoadons;
    }

    public void setChitiethoadons(Set<Chitiethoadon> chitiethoadons) {
        this.chitiethoadons = chitiethoadons;
    }

    @ManyToOne
    @JoinColumn(name = "DanhMuc", referencedColumnName = "DanhMucID", nullable = false)
    public Danhmuc getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(Danhmuc danhmuc) {
        this.danhmuc = danhmuc;
    }
}
