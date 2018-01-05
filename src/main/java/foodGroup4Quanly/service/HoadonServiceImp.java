package foodGroup4Quanly.service;

import java.util.List;

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

	@Override
	public List<Hoadon> getListHoaDonTaiQuan(int maxResult, int begin) {
		return hoadonDAO.getListHoaDonTaiQuan(maxResult, begin);
	}
	@Override
	public List<Hoadon> notConfirm() {
		return hoadonDAO.notConfirm();
	}

	@Override
	public List<Hoadon> getListHoaDonTongDai(int maxResult, int begin) {
		return hoadonDAO.getListHoaDonTongDai(maxResult, begin);
	}
	@Override
	public int getCount(String loaihoadon) {
		// TODO Auto-generated method stub
		return hoadonDAO.getCount(loaihoadon);
	}

	@Override
	public List<Hoadon> getListHoaDonMangVe(int maxResult, int begin) {
		return hoadonDAO.getListHoaDonMangVe(maxResult, begin);
	}
	@Override
	public List<Hoadon> getlist(String loaihoadon, int begin, int maxresult) {
		// TODO Auto-generated method stub
		return hoadonDAO.getlist(loaihoadon, begin, maxresult);
	}

	@Override
	public int countTongDai() {
		return hoadonDAO.countTongDai();
	}



   

	@Override
	public int countMangVe() {
		return hoadonDAO.countMangVe();
	}

	@Override
	public int countTaiQuan() {
		return hoadonDAO.countTaiQuan();
	}





}














