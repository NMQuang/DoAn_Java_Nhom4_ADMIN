package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chinhanhmon", schema = "java_foodsystem")
@AssociationOverrides({
        @AssociationOverride(name = "pk.chinhanh", joinColumns = @JoinColumn(name = "ChiNhanh")),
        @AssociationOverride(name = "pk.mon", joinColumns = @JoinColumn(name = "Mon"))
})
public class Chinhanhmon implements Serializable {
    private ChinhanhmonId pk = new ChinhanhmonId();
    private int gia;

    @EmbeddedId
    public ChinhanhmonId getPk() {
        return pk;
    }

    public void setPk(ChinhanhmonId pk) {
        this.pk = pk;
    }

    @Transient
    public Chinhanh getChinhanh() {
        return getPk().getChinhanh();
    }

    public void setChinhanh(Chinhanh chinhanh) {
        getPk().setChinhanh(chinhanh);
    }

    @Transient
    public Mon getMon() {
        return getPk().getMon();
    }

    public void setMon(Mon mon) {
        getPk().setMon(mon);
    }

    @Basic
    @Column(name = "Gia")
    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chinhanhmon that = (Chinhanhmon) o;

        if (pk != that.pk) return false;
        if (gia != that.gia) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gia;
        result = 31 * result + gia;
        return result;
    }
}
