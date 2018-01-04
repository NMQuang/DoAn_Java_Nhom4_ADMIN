package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chitiethoadon;

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

	@Override
	public List<Chitiethoadon> getByIDHoaDon(int idHoaDon) {
		String hql = "from Chitiethoadon where pk.hoadon.hoaDonId = :idHoaDon";
		Query query = getSession().createQuery(hql);
		query.setParameter("idHoaDon", idHoaDon);
		return query.list();
	}
	
}
