package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ban", schema = "java_foodsystem", catalog = "")
public class Ban {
    private int banId;
    private String tenBan;
    private int tinhTrang;
    private Chinhanh chinhanh;
    private Set<Hoadon> hoadons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BanID")
    public int getBanId() {
        return banId;
    }

    public void setBanId(int banId) {
        this.banId = banId;
    }

    @Basic
    @Column(name = "TenBan")
    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    @Basic
    @Column(name = "TinhTrang")
    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ban ban = (Ban) o;

        if (banId != ban.banId) return false;
        if (tinhTrang != ban.tinhTrang) return false;
        if (tenBan != null ? !tenBan.equals(ban.tenBan) : ban.tenBan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = banId;
        result = 31 * result + (tenBan != null ? tenBan.hashCode() : 0);
        result = 31 * result + tinhTrang;
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

    @OneToMany(mappedBy = "ban")
    public Set<Hoadon> getHoadons() {
        return hoadons;
    }

    public void setHoadons(Set<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }
}
