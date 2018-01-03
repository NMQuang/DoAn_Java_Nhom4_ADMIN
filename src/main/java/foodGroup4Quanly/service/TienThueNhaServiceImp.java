package foodGroup4Quanly.service;

import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.entity.Tienthuenha;
import foodGroup4Quanly.entity.TienthuenhaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class TienThueNhaServiceImp implements TienThueNhaService {

    @Autowired
    TienThueNhaDao tienThueNhaDao;

    @Override
    public List<Tienthuenha> getTienThueNhaOfYear(String year) {
        return tienThueNhaDao.getTienThueNhaOfYear(year);
    }

    @Override
    public Tienthuenha getById(TienthuenhaPK pk) {
        return tienThueNhaDao.getById(pk);
    }

    @Override
    public void create(Tienthuenha tienthuenha) {
        tienThueNhaDao.create(tienthuenha);
    }
}
