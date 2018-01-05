package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Hoadon;

@Component
public class HoaDonDaoImp extends HibernateUtil implements HoaDonDao{

	@Override
	public List<Hoadon> getListIn(Date begin, Date end) {
		String hql = "from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return query.list();
	}
	

	@Override
	public long getSum(Date begin, Date end) {
		String hql = "select COALESCE(sum(tongTien),0) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (Long)query.uniqueResult();
	}

	@Override
	public long getCount(Date begin, Date end) {
		String hql = "select count(*) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return (long) query.uniqueResult();
	}


	@Override
	public List<Hoadon> getListIn(Date begin, Date end, int chinhanh) {
		String hql = "from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end and chinhanh.chiNhanhId = :chinhanh";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("chinhanh", chinhanh);
		return query.list();
	}


	@Override
	public long getSum(Date begin, Date end, int chinhanh) {
		String hql = "select COALESCE(sum(tongTien),0) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end and chinhanh.chiNhanhId = :chinhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("chinhanh", chinhanh);
		return (Long)query.uniqueResult();
	}


	@Override
	public long getCountTypeBill(Date begin, Date end, int chinhanh, String loai) {
		String hql = "select count(*) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end and chinhanh.chiNhanhId = :chinhanh and hinhThucMua = :hinhThucMua";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("chinhanh", chinhanh);
		query.setParameter("hinhThucMua", loai);
		return (Long)query.uniqueResult();
	}


	@Override
	public long getCountTypeBill(Date begin, Date end, String loai) {
		String hql = "select count(*) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end  and hinhThucMua = :hinhThucMua";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("hinhThucMua", loai);
		return (Long)query.uniqueResult();
	}


	@Override
	public long getSum(Date begin, Date end, String sdt) {
		String hql = "select COALESCE(sum(tongTien),0) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end and khachhang.sdt = :sdt";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("sdt", sdt);
		return (Long)query.uniqueResult();
	}


	@Override
	public long getCount(Date begin, Date end, String sdt) {
		String hql = "select count(*) from Hoadon where ngayTraTien >= :begin and ngayTraTien < :end and khachhang.sdt = :sdt";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("sdt", sdt);
		return (long) query.uniqueResult();
	}


	@Override
	public Hoadon getTheLastBillByTableStillCooking(int idBan) {
		String hql = "from Hoadon where tinhTrangGiaoHang =  :dang_che_bien and ban.banId = :idBan order by hoaDonId DESC";
		Query query = getSession().createQuery(hql);
		query.setParameter("dang_che_bien", TinhTrangGiaoHang.DANG_CHE_BIEN);
		query.setParameter("idBan", idBan);
		List dshd = query.setFirstResult(0).setMaxResults(1).list();
		if(dshd.size() > 0)
			return (Hoadon) dshd.get(0);
		else
			return null;
	}


	@Override
	public List<Hoadon> notConfirm() {
		String hql = "from Hoadon where tinhTrangGiaoHang = :chua_confirm";
		Query query = getSession().createQuery(hql);
		query.setParameter("chua_confirm", TinhTrangGiaoHang.DANG_XU_LY);
		return query.list();
	}


	@Override
	public int getCount(String loaihoadon) {
		String hql = "select count(*) from Hoadon where hinhThucMua = :loai and tinhTrangGiaoHang != :tinhtrang";
		Query query = getSession().createQuery(hql);
		query.setParameter("loai", loaihoadon);
		query.setParameter("tinhtrang", TinhTrangGiaoHang.DANG_XU_LY);
		int count = ((Long) query.uniqueResult()).intValue();
		return count;
	}


	@Override
	public List<Hoadon> getlist(String loaihoadon, int begin, int maxresult) {
		String hql = "from Hoadon where hinhThucMua = :loai and tinhTrangGiaoHang != :tinhtrang order by hoaDonId desc";
		Query query = getSession().createQuery(hql);
		query.setParameter("loai", loaihoadon);
		query.setParameter("tinhtrang", TinhTrangGiaoHang.DANG_XU_LY);
		query.setFirstResult(begin).setMaxResults(maxresult);
		return query.list();
	}


	

	
	

}
