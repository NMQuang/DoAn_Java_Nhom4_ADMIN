package foodGroup4Quanly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.dao.HoaDonDao;
import foodGroup4Quanly.dao.HoaDonDaoImp;
import foodGroup4Quanly.entity.Hoadon;

@Component
@Transactional
public class HoadonServiceImp implements HoadonService {

    @Autowired
    HoaDonDao hoadonDAO;

	@Override
	public void create(Hoadon hoadon) {
		((HoaDonDaoImp)hoadonDAO).create(hoadon);
	}

	@Override
	public Hoadon getTheLastBillByTableStillCooking(int idBan) {
		return hoadonDAO.getTheLastBillByTableStillCooking(idBan);
	}

	@Override
	public void delete(Hoadon hoadon) {
		((HoaDonDaoImp)hoadonDAO).delete(hoadon);
	}

	@Override
	public void update(Hoadon hoadon) {
		((HoaDonDaoImp)hoadonDAO).update(hoadon);
	}

	@Override
	public Hoadon getBillById(int id) {
		return ((HoaDonDaoImp)hoadonDAO).fetchById(id, Hoadon.class);
	}




   

}














