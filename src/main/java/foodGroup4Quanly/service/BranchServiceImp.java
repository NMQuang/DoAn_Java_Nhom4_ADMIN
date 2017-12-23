package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.BranchDao;
import foodGroup4Quanly.entity.Chinhanh;

@Component
@Transactional
public class BranchServiceImp implements BranchService {

	@Autowired
	public BranchDao branchDao;

	@Override
	public List<Chinhanh> getListChiNhanh() {
		if (branchDao.getListChiNhanh().size() > 0) {
			return branchDao.getListChiNhanh();
		} else {
			return null;
		}
	}

	@Override
	public void saveChiNhanh(Chinhanh chiNhanh) {

		branchDao.saveChiNhanh(chiNhanh);
	}

	@Override
	public Chinhanh getInfoChiNhanh(int idChinhanh) {
		if (branchDao.getInfoChiNhanh(idChinhanh) != null) {
			return branchDao.getInfoChiNhanh(idChinhanh);
		} else {
			return null;
		}
	}

}
