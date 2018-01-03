package foodGroup4Quanly.service;

import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.entity.Tienthuenha;
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
    public List<Tienthuenha> getTienThueNhaOfYear(int year) {
        return tienThueNhaDao.getTienThueNhaOfYear(year);
    }
}
