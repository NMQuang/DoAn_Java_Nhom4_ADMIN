package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.dao.DanhMucDao;
import foodGroup4Quanly.entity.Danhmuc;

@Component
@Transactional
public class DanhMucServiceImp implements DanhMucService{

	@Autowired
	private DanhMucDao danhMucDao;
	@Override
	public List<Danhmuc> getAllDanhMuc() {
		//return ((HibernateUtil)danhMucDao).fetchAll("from Danhmuc where active is true");
		return danhMucDao.getAllDanhmucs();
	}
	@Override
	public Danhmuc get(int id) {
		return ((HibernateUtil)danhMucDao).fetchById(id, Danhmuc.class);
	}

	
}
