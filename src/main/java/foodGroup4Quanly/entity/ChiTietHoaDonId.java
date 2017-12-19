package foodGroup4Quanly.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ChiTietHoaDonId implements Serializable {
    private Hoadon hoadon;
    private Mon mon;

    @ManyToOne
    public Mon getMon() {

        return mon;
    }

    public void setMon(Mon mon) {
        this.mon = mon;
    }

    @ManyToOne
    public Hoadon getHoadon() {

        return hoadon;
    }

    public void setHoadon(Hoadon hoadon) {

        this.hoadon = hoadon;
    }
}
