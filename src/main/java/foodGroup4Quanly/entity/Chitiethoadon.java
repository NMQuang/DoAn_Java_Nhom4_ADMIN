package foodGroup4Quanly.entity;

import javax.persistence.*;

@Entity
@Table(name = "chitiethoadon", schema = "java_foodsystem")
@AssociationOverrides({
        @AssociationOverride(name = "pk.hoadon", joinColumns = @JoinColumn(name = "HoaDon")),
        @AssociationOverride(name = "pk.mon", joinColumns = @JoinColumn(name = "Mon"))
})
public class Chitiethoadon {
    private ChiTietHoaDonId pk = new ChiTietHoaDonId();
    private int soLuong;
    private int tongTien;

    @EmbeddedId
    public ChiTietHoaDonId getPk() {

        return pk;
    }

    public void setPk(ChiTietHoaDonId pk) {
        this.pk = pk;
    }

    @Transient
    public Hoadon getHoadon() {
        return getPk().getHoadon();
    }

    public void setHoadon(Hoadon hoadon) {
        getPk().setHoadon(hoadon);
    }

    @Transient
    public Mon getMon() {
        return getPk().getMon();
    }

    public void setMon(Mon mon) {
        getPk().setMon(mon);
    }

    @Basic
    @Column(name = "SoLuong")
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Basic
    @Column(name = "TongTien")
    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chitiethoadon that = (Chitiethoadon) o;

        if (soLuong != that.soLuong) return false;
        if (tongTien != that.tongTien) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = soLuong;
        result = 31 * result + soLuong;
        result = 31 * result + tongTien;
        return result;
    }
}
