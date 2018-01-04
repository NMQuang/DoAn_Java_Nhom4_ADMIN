package foodGroup4Quanly.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.dao.KhachHangDao;
import foodGroup4Quanly.dao.KhachHangDaoImp;
import foodGroup4Quanly.entity.Khachhang;

@Component
@Transactional
public class KhachHangServiceImp implements KhachHangService{

	@Autowired
	private KhachHangDao khachHangDao;
	@Override
	public Khachhang get(String sdt) {
		// TODO Auto-generated method stub
		return khachHangDao.get(sdt);
	}
	@Override
	public void create(Khachhang kh) {
		((KhachHangDaoImp)khachHangDao).create(kh);
	}

}
