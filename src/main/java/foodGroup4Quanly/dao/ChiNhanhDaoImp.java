package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chinhanh;

@Component
public class ChiNhanhDaoImp extends HibernateUtil implements ChiNhanhDao {

	/**
	 * get list branch
	 * @param
	 * */
	@Override
	public List<Chinhanh> getListBranch() {
		String hql = "from Chinhanh";
		Query query = getSession().createQuery(hql);
		List<Chinhanh> chiNhanhs = query.list();
		return chiNhanhs;
	}

	/**
	 * get info of a branch by branchID
	 * @param branchID int
	 * */
	@Override
	public Chinhanh getInfoBranch(int branchID) {
		Chinhanh chiNhanh = new Chinhanh();
		String hql = "from Chinhanh where chiNhanhId = :branchID";
		Query query = getSession().createQuery(hql).setParameter("branchID", branchID);
		if (query.list().isEmpty()) {
			return null;
		} else {
			chiNhanh = (Chinhanh) query.list().get(0);
			return chiNhanh;
		}
	}

}
