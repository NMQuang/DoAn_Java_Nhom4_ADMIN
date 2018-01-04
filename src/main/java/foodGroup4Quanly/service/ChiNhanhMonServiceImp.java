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

	@Override
	public List<Chinhanhmon> getListChiNhanhMonByChiNhanh(int idChiNhanh) {
		List<Chinhanhmon> list = chiNhanhMonDAO.getListChiNhanhMonByChiNhanh(idChiNhanh);
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void save(Chinhanhmon chiNhanhMon) {

		chiNhanhMonDAO.save(chiNhanhMon);
	}

	@Override
	public void delete(int idChinhanh, int idMon) {

		chiNhanhMonDAO.delete(idChinhanh, idMon);
	}

	@Override
	public int countMonByChiNhanh(int idChiNhanh) {
		int count = chiNhanhMonDAO.countMonByChiNhanh(idChiNhanh);
		if (count <= 0) {
			return 0;
		}
		return count;
	}

	@Override
	public List<Chinhanhmon> getListChiNhanhMonPageByChiNhanh(int idChiNhanh, int maxResult, int begin) {
		return chiNhanhMonDAO.getListChiNhanhMonPageByChiNhanh(idChiNhanh, maxResult, begin);
	}

}
