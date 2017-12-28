package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.TinhThanhDao;
import foodGroup4Quanly.entity.Tinhthanh;

@Component
@Transactional
public class TinhThanhServiceImp implements TinhThanhService {

	@Autowired
	public TinhThanhDao tinhThanhDao;

	@Override
	public List<Tinhthanh> getAllTinhThanh() {
		List<Tinhthanh> list = tinhThanhDao.getAllTinhThanh();
		if (list.size() < 0) {
			return null;
		} else {
			return list;
		}
	}
}
