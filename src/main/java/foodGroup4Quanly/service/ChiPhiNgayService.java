package foodGroup4Quanly.service;

import foodGroup4Quanly.entity.Chiphingay;

import java.util.Date;
import java.util.List;

public interface ChiPhiNgayService {
    List<Chiphingay> getChiPhiNgayInDate(Date date);

    void create(Chiphingay chiphingay);

    Chiphingay getById(int id);

    void update(Chiphingay chiphingay);

}
