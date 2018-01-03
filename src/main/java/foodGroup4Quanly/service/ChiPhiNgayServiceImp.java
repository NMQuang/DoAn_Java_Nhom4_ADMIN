package foodGroup4Quanly.service;

import foodGroup4Quanly.dao.ChiPhiNgayDao;
import foodGroup4Quanly.entity.Chiphingay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class ChiPhiNgayServiceImp implements ChiPhiNgayService {

    @Autowired
    ChiPhiNgayDao chiPhiNgayDao;

    @Override
    public List<Chiphingay> getChiPhiNgayInDate(Date date) {
        return chiPhiNgayDao.getChiPhiNgayInDate(date);
    }

    @Override
    public void create(Chiphingay chiphingay) {
        chiPhiNgayDao.create(chiphingay);
    }

    @Override
    public Chiphingay getById(int id) {
        return chiPhiNgayDao.getById(id);
    }

    @Override
    public void update(Chiphingay chiphingay) {
        chiPhiNgayDao.update(chiphingay);
    }

    @Override
    public void deleteById(int id) {
        chiPhiNgayDao.deleteById(id);
    }
}
