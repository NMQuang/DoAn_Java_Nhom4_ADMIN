package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.ChiTietHoaDonDao;
import foodGroup4Quanly.entity.Chitiethoadon;

@Component
@Transactional
public class ChiTietHoaDonServiceImp implements ChiTietHoaDonService{

	@Autowired
	private ChiTietHoaDonDao chiTietHoaDonDao;
	
	@Override
	public List<Chitiethoadon> getByIDHoaDon(int idHoaDon) {
		return chiTietHoaDonDao.getByIDHoaDon(idHoaDon);
	}

}
