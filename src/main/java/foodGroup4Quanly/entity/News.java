package foodGroup4Quanly.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "news", schema = "java_foodsystem")
public class News {
    private int newId;
    private String chuDe;
    private String noiDung;
    private Date ngay;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NewID")
    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    @Basic
    @Column(name = "ChuDe")
    public String getChuDe() {
        return chuDe;
    }

    public void setChuDe(String chuDe) {
        this.chuDe = chuDe;
    }

    @Basic
    @Column(name = "NoiDung")
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Basic
    @Column(name = "Ngay")
    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (newId != news.newId) return false;
        if (chuDe != null ? !chuDe.equals(news.chuDe) : news.chuDe != null) return false;
        if (noiDung != null ? !noiDung.equals(news.noiDung) : news.noiDung != null) return false;
        if (ngay != null ? !ngay.equals(news.ngay) : news.ngay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newId;
        result = 31 * result + (chuDe != null ? chuDe.hashCode() : 0);
        result = 31 * result + (noiDung != null ? noiDung.hashCode() : 0);
        result = 31 * result + (ngay != null ? ngay.hashCode() : 0);
        return result;
    }
}
