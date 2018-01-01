package foodGroup4Quanly.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.dao.KhachHangDao;
import foodGroup4Quanly.entity.Khachhang;

@Component
@Transactional
public class KhachHangServiceImp implements KhachHangService{

	@Autowired
	private KhachHangDao KhachHangDao;
	@Override
	public Khachhang get(String sdt) {
		// TODO Auto-generated method stub
		return KhachHangDao.get(sdt);
	}

}
