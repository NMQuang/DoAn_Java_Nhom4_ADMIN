package foodGroup4Quanly.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "danhmuc",  schema = "java_foodsystem")
public class Danhmuc {
    private int danhMucId;
    private String ten;
    private Boolean active;
    private Set<Mon> mons;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DanhMucID")
    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
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

        Danhmuc danhmuc = (Danhmuc) o;

        if (danhMucId != danhmuc.danhMucId) return false;
        if (ten != null ? !ten.equals(danhmuc.ten) : danhmuc.ten != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = danhMucId;
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "danhmuc")
    public Set<Mon> getMons() {
        return mons;
    }

    public void setMons(Set<Mon> mons) {
        this.mons = mons;
    }
}
