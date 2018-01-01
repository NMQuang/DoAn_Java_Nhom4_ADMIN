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

		List<Chinhanh> list = branchDao.getListChiNhanh();
		if (list.size() > 0) {
			return list;
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
		Chinhanh chinhanh = branchDao.getInfoChiNhanh(idChinhanh);
		if ( chinhanh!= null) {
			return chinhanh;
		} else {
			return null;
		}
	}

	@Override
	public void update(Chinhanh chiNhanh) {
		branchDao.update(chiNhanh);
	}

	@Override
	public int countBranch() {
		return branchDao.countBrand();
	}

	@Override
	public List<Chinhanh> getList(int maxResult, int begin) {
		return branchDao.getList(maxResult, begin);
	}

}
