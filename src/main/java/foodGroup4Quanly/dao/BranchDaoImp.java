package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chinhanh;

@Component
public class BranchDaoImp implements BranchDao {

	@Autowired
	public HibernateUtil  hibernateUtil;

	@Override
	public List<Chinhanh> getListChiNhanh() {
		String hql = "from Chinhanh";
		Query query = hibernateUtil.getSession().createQuery(hql);
	        return query.list();
	}

	@Override
	public void saveChiNhanh(Chinhanh chiNhanh) {

		hibernateUtil.create(chiNhanh);
	}

	@Override
	public Chinhanh getInfoChiNhanh(int idChinhanh) {
		Chinhanh chiNhanh = new Chinhanh();
		String hql = "from Chinhanh where chiNhanhId = :idChinhanh";
		Query query = hibernateUtil.getSession().createQuery(hql).setParameter("idChinhanh", idChinhanh);
		if (query.list().isEmpty()) {
			return null;
		} else {
			chiNhanh = (Chinhanh) query.list().get(0);
			return chiNhanh;
		}
	}

	@Override
	public void update(Chinhanh chiNhanh) {

		hibernateUtil.update(chiNhanh);
	}
}
