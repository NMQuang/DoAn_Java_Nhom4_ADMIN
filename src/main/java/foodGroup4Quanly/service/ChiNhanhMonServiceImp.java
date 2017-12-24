package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.ChiNhanhMonDAO;
import foodGroup4Quanly.entity.Chinhanhmon;

@Component
@Transactional
public class ChiNhanhMonServiceImp implements ChiNhanhMonService{

	@Autowired
	ChiNhanhMonDAO chiNhanhMonDAO;

	@Override
	public List<Chinhanhmon> getListChiNhanhMonByMon(int idMon) {
		return chiNhanhMonDAO.getListChiNhanhMon(idMon);
	}

}
