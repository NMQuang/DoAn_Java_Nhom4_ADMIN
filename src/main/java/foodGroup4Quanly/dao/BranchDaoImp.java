package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chinhanh;

public class BranchDaoImp implements BranchDao {

	@Autowired
	public HibernateUtil  hibernateUtil;

	@Override
	public List<Chinhanh> getListChiNhanh() {
		String hql = "from chinhanh";
		Query query = hibernateUtil.getSession().createQuery(hql);
	        return query.list();
	}

	@Override
	public void saveChiNhanh(Chinhanh chiNhanh) {

		hibernateUtil.create(chiNhanh);
	}
}
