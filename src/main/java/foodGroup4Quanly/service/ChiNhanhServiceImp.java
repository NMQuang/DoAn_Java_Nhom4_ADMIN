package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.ChiNhanhDao;
import foodGroup4Quanly.entity.Chinhanh;

@Component
@Transactional
public class ChiNhanhServiceImp implements ChiNhanhService{

	@Autowired
	private ChiNhanhDao chiNhanhDao;
	@Override
	public List<Chinhanh> getListChiNhanh() {
//		return ((HibernateUtil)chiNhanhDao).fetchAll(Chinhanh.class);
		return chiNhanhDao.getListBranch();
	}

	/**
	 * get info of a branch by branchID
	 * @param branchID int
	 * */
	@Override
	public Chinhanh getInfoBranch(int branchID) {

		if (branchID < 0) {
			return null;
		}
		return chiNhanhDao.getInfoBranch(branchID);
	}

}
