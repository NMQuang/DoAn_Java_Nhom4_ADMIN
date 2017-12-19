package foodGroup4Quanly.entity;

import javax.persistence.*;

@Entity
@Table(name = "tinhthanh", schema = "java_foodsystem")
public class Tinhthanh {
    private int tinhThanhId;
    private String tenTinh;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TinhThanhID")
    public int getTinhThanhId() {
        return tinhThanhId;
    }

    public void setTinhThanhId(int tinhThanhId) {
        this.tinhThanhId = tinhThanhId;
    }

    @Basic
    @Column(name = "TenTinh")
    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tinhthanh tinhthanh = (Tinhthanh) o;

        if (tinhThanhId != tinhthanh.tinhThanhId) return false;
        if (tenTinh != null ? !tenTinh.equals(tinhthanh.tenTinh) : tinhthanh.tenTinh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tinhThanhId;
        result = 31 * result + (tenTinh != null ? tenTinh.hashCode() : 0);
        return result;
    }
}
