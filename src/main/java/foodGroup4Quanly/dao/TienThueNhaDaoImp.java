package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.TienthuenhaPK;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Tienthuenha;

@Component
public class TienThueNhaDaoImp extends HibernateUtil implements TienThueNhaDao{

	@Override
	public long getSum(Date begin, Date end) {
		String hql = "select COALESCE(SUM(tien), 0) from Tienthuenha where ngayChi >= :begin and ngayChi < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (long) query.uniqueResult();
	}

	@Override
	public long getSum(Date begin, Date end, int ChiNhanh) {
		String hql = "select COALESCE(SUM(tien), 0) from Tienthuenha where ngayChi >= :begin and ngayChi < :end and chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return (long) query.uniqueResult();
	}

	@Override
	public List<Tienthuenha> getListIn(Date begin, Date end) {
		String hql = "from Tienthuenha where ngayChi >= :begin and ngayChi < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return query.list();
	}

	@Override
	public List<Tienthuenha> getListIn(Date begin, Date end, int ChiNhanh) {
		String hql = "from Tienthuenha where ngayChi >= :begin and ngayChi < :end and chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return query.list();
	}

	@Override
	public List<Tienthuenha> getTienThueNhaOfYear(String year) {
		//language=HQL
		String hql = "from Tienthuenha  where nam=:year";
		Query query = getSession().createQuery(hql).setParameter("year", year);

		return query.list();
	}

	@Override
	public Tienthuenha getById(TienthuenhaPK pk) {
		return super.fetchById(pk, Tienthuenha.class);
	}

	@Override
	public void create(Tienthuenha tienthuenha) {
		super.create(tienthuenha);
	}

}
