package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import foodGroup4Quanly.entity.LuongchonhanvienPK;
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

	@Override
	public boolean hasLuongNhanVien(int nhanVien, String thang, String nam) {
		//language=HQL
		String hql = "from Luongchonhanvien where (nhanVien=:nhanVien and thang=:thang and nam=:nam)";
		Query query = this.getSession().createQuery(hql)
				.setParameter("nhanVien", nhanVien)
				.setParameter("thang", thang)
				.setParameter("nam", nam);

		return query.list().size() > 0;
	}

	@Override
	public void create(Luongchonhanvien luongNv) {
		super.create(luongNv);
	}

	@Override
	public List<Luongchonhanvien> getLuongNhanVien(String month, String year, int chiNhanhId) {
		//language=HQL
		String hql = "from Luongchonhanvien where thang=:month and nam=:year and nhanvien.chinhanh.id=:chiNhanhId";
		Query query = getSession().createQuery(hql)
				.setParameter("month", month)
				.setParameter("year", year)
				.setParameter("chiNhanhId", chiNhanhId);

		return query.list();
	}

	@Override
	public Luongchonhanvien findById(int idNhanVien, String thang, String nam) {
		return super.fetchById(new LuongchonhanvienPK(idNhanVien, thang, nam), Luongchonhanvien.class);
	}

	@Override
	public void update(Luongchonhanvien luongNv) {
		super.update(luongNv);
	}


}
