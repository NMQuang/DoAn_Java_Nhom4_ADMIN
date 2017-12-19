package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chinhanh", schema = "java_foodsystem", catalog = "")
public class Chinhanh {
    private int chiNhanhId;
    private String ten;
    private String diaChi;
    private String dienThoai;
    private String hinhAnh;
    private Set<AccountAdmin> accountAdmins;
    private Set<Ban> bans;
    private Tinhthanh tinhthanh;
    private Set<Chinhanhmon> chinhanhmons;
    private Set<Chiphingay> chiphingays;
    private Set<Hoadon> hoadons;
    private Set<Nhanvien> nhanviens;
    private Set<Tienthuenha> tienthuenhas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChiNhanhID")
    public int getChiNhanhId() {
        return chiNhanhId;
    }

    public void setChiNhanhId(int chiNhanhId) {
        this.chiNhanhId = chiNhanhId;
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
    @Column(name = "DiaChi")
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Basic
    @Column(name = "DienThoai")
    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    @Basic
    @Column(name = "hinhAnh")
    public String getHinhAnh() {
	return hinhAnh;
}

    public void setHinhAnh(String hinhAnh) {
	this.hinhAnh = hinhAnh;
    }

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chinhanh chinhanh = (Chinhanh) o;

        if (chiNhanhId != chinhanh.chiNhanhId) return false;
        if (ten != null ? !ten.equals(chinhanh.ten) : chinhanh.ten != null) return false;
        if (diaChi != null ? !diaChi.equals(chinhanh.diaChi) : chinhanh.diaChi != null) return false;
        if (dienThoai != null ? !dienThoai.equals(chinhanh.dienThoai) : chinhanh.dienThoai != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chiNhanhId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (diaChi != null ? diaChi.hashCode() : 0);
        result = 31 * result + (dienThoai != null ? dienThoai.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<AccountAdmin> getAccountAdmins() {
        return accountAdmins;
    }

    public void setAccountAdmins(Set<AccountAdmin> accountAdmins) {
        this.accountAdmins = accountAdmins;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<Ban> getBans() {
        return bans;
    }

    public void setBans(Set<Ban> bans) {
        this.bans = bans;
    }

    @ManyToOne
    @JoinColumn(name = "TinhThanh", referencedColumnName = "TinhThanhID", nullable = false)
    public Tinhthanh getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(Tinhthanh tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    @OneToMany(mappedBy = "pk.chinhanh", cascade = CascadeType.ALL)
    public Set<Chinhanhmon> getChinhanhmons() {
        return chinhanhmons;
    }

    public void setChinhanhmons(Set<Chinhanhmon> chinhanhmons) {
        this.chinhanhmons = chinhanhmons;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<Chiphingay> getChiphingays() {
        return chiphingays;
    }

    public void setChiphingays(Set<Chiphingay> chiphingays) {
        this.chiphingays = chiphingays;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<Hoadon> getHoadons() {
        return hoadons;
    }

    public void setHoadons(Set<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(Set<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    @OneToMany(mappedBy = "chinhanh")
    public Set<Tienthuenha> getTienthuenhas() {
        return tienthuenhas;
    }

    public void setTienthuenhas(Set<Tienthuenha> tienthuenhas) {
        this.tienthuenhas = tienthuenhas;
    }
}
