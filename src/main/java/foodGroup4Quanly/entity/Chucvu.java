package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chucvu",  schema = "java_foodsystem")
public class Chucvu {
    private int chucVuId;
    private String ten;
    private int moTa;
    private Set<Nhanvien> nhanviens;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChucVuID")
    public int getChucVuId() {
        return chucVuId;
    }

    public void setChucVuId(int chucVuId) {
        this.chucVuId = chucVuId;
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
    public int getMoTa() {
        return moTa;
    }

    public void setMoTa(int moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chucvu chucvu = (Chucvu) o;

        if (chucVuId != chucvu.chucVuId) return false;
        if (moTa != chucvu.moTa) return false;
        if (ten != null ? !ten.equals(chucvu.ten) : chucvu.ten != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chucVuId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + moTa;
        return result;
    }

    @OneToMany(mappedBy = "chucvu")
    public Set<Nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(Set<Nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }
}
