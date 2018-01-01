package foodGroup4Quanly.dao;

import java.util.Date;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;

@Component
public class ChiTietHoaDonDaoImp extends HibernateUtil implements ChiTietHoaDonDao{

	@Override
	public long getSumMon(Date begin, Date end) {
		String hql = "select COALESCE(SUM(soLuong), 0) from Chitiethoadon where pk.hoadon.ngayTraTien >= :begin and pk.hoadon.ngayTraTien < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (long) query.uniqueResult();
	}

	@Override
	public long getSumMon(Date begin, Date end, int ChiNhanh) {
		String hql = "select COALESCE(SUM(soLuong), 0) from Chitiethoadon where pk.hoadon.ngayTraTien >= :begin and pk.hoadon.ngayTraTien < :end and pk.hoadon.chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return (long) query.uniqueResult();
	}
	
}
