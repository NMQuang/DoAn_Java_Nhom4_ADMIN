package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Hoadon;

@Component
public class HoaDonDaoImp extends HibernateUtil implements HoaDonDao{

	@Override
	public List<Hoadon> getListIn(Date begin, Date end) {
		String hql = "from Hoadon where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return query.list();
	}
	

	@Override
	public long getSum(Date begin, Date end) {
		String hql = "select COALESCE(sum(tongTien),0) from Hoadon where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (Long)query.uniqueResult();
	}


	@Override
	public List<Hoadon> getListIn(Date begin, Date end, int chinhanh) {
		String hql = "from Hoadon where ngay >= :begin and ngay < :end and chinhanh.chiNhanhId = :chinhanh";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("chinhanh", chinhanh);
		return query.list();
	}


	@Override
	public long getSum(Date begin, Date end, int chinhanh) {
		String hql = "select COALESCE(sum(tongTien),0) from Hoadon where ngay >= :begin and ngay < :end and chinhanh.chiNhanhId = :chinhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("chinhanh", chinhanh);
		return (Long)query.uniqueResult();
	}


	
	

}
