package foodGroup4Quanly.entity;

import javax.persistence.*;

@Entity
@Table(name = "trungtam", schema = "java_foodsystem")
public class Trungtam {
    private int trungTamId;
    private long soLuongTruyCap;
    private String hotline;
    private String ten;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrungTamID")
    public int getTrungTamId() {
        return trungTamId;
    }

    public void setTrungTamId(int trungTamId) {
        this.trungTamId = trungTamId;
    }

    @Basic
    @Column(name = "SoLuongTruyCap")
    public long getSoLuongTruyCap() {
        return soLuongTruyCap;
    }

    public void setSoLuongTruyCap(long soLuongTruyCap) {
        this.soLuongTruyCap = soLuongTruyCap;
    }

    @Basic
    @Column(name = "Hotline")
    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    @Basic
    @Column(name = "Ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trungtam trungtam = (Trungtam) o;

        if (trungTamId != trungtam.trungTamId) return false;
        if (soLuongTruyCap != trungtam.soLuongTruyCap) return false;
        if (hotline != null ? !hotline.equals(trungtam.hotline) : trungtam.hotline != null) return false;
        if (ten != null ? !ten.equals(trungtam.ten) : trungtam.ten != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trungTamId;
        result = 31 * result + (int) (soLuongTruyCap ^ (soLuongTruyCap >>> 32));
        result = 31 * result + (hotline != null ? hotline.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        return result;
    }
}
