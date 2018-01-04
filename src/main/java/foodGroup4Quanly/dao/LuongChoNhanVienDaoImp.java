package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Luongchonhanvien;

@Component
public class LuongChoNhanVienDaoImp extends HibernateUtil implements LuongChoNhanVienDao{

	@Override
	public long getSum(Date begin, Date end) {
		String hql = "select COALESCE(SUM(tien), 0) from Luongchonhanvien where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (long) query.uniqueResult();
	}

	@Override
	public long getSum(Date begin, Date end, int ChiNhanh) {
		String hql = "select COALESCE(SUM(tien), 0) from Luongchonhanvien where ngay >= :begin and ngay < :end and nhanvien.chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return (long) query.uniqueResult();
	}

	@Override
	public List<Luongchonhanvien> getListIn(Date begin, Date end) {
		String hql = "from Luongchonhanvien where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return query.list();
	}

	@Override
	public List<Luongchonhanvien> getListIn(Date begin, Date end, int ChiNhanh) {
		String hql = "from Luongchonhanvien where ngay >= :begin and ngay < :end and nhanvien.chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return query.list();
	}

	@Override
	public List<TongLuongNhanVienTheoThangDto> getListTongLuongTheoThang(String year, int idChiNhanh) {
		//language=HQL
		String hql = "select new foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto (L.thang, L.nam,  L.ngay, sum(L.tien)) from Luongchonhanvien L where (L.nam=:year and L.nhanvien.chinhanh.id=:idChiNhanh) group by L.thang";
		Query query = this.getSession().createQuery(hql).setParameter("year", year).setParameter("idChiNhanh", idChiNhanh);

		return query.list();
	}

}
