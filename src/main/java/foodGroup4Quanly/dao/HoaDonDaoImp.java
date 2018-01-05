package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.common.state.HinhThucMua;
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
	public List<Hoadon> getListHoaDonTaiQuan(int maxResult, int begin) {
		String hql = "from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:tai_cho order by hoaDonId ASC";
		Query query = getSession().createQuery(hql);
		query.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY);
		query.setParameter("tai_cho", HinhThucMua.TAI_CHO);
		List dshd = query.setFirstResult(begin).setMaxResults(maxResult).list();
		if(dshd.size() > 0)
			return dshd;
		else
			return null;
	}

	@Override
	public List<Hoadon> getListHoaDonMangVe(int maxResult, int begin) {
		String hql = "from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:mang_ve order by hoaDonId ASC";
		Query query = getSession().createQuery(hql);
		query.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY);
		query.setParameter("mang_ve", HinhThucMua.MANG_VE);
		List dshd = query.setFirstResult(begin).setMaxResults(maxResult).list();
		if(dshd.size() > 0)
			return dshd;
		else
			return null;
	}


	@Override
	public List<Hoadon> getListHoaDonTongDai(int maxResult, int begin) {
		String hql = "from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:tong_dai order by hoaDonId ASC";
		Query query = getSession().createQuery(hql);
		query.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY);
		query.setParameter("tong_dai", HinhThucMua.TONG_DAI);
		List dshd = query.setFirstResult(begin).setMaxResults(maxResult).list();
		if(dshd.size() > 0)
			return dshd;
		else
			return null;
	}


	@Override
	public int countTongDai() {
		Query query = getSession().createQuery("select count(*)  from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:tong_dai")
				.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY)
				.setParameter("tong_dai", HinhThucMua.TONG_DAI);
	    	int count = ((Long) query.uniqueResult()).intValue();
	    	return count;
	}


	@Override
	public int countTaiQuan() {
		Query query = getSession().createQuery("select count(*)  from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:tai_cho")
				.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY)
				.setParameter("tai_cho", HinhThucMua.TAI_CHO);
	    	int count = ((Long) query.uniqueResult()).intValue();
	    	return count;
	}


	@Override
	public int countMangVe() {
		Query query = getSession().createQuery("select count(*)  from Hoadon where tinhTrangGiaoHang <>:dang_xu_ly and hinhThucMua =:mang_ve")
				.setParameter("dang_xu_ly", TinhTrangGiaoHang.DANG_XU_LY)
				.setParameter("mang_ve", HinhThucMua.MANG_VE);
	    	int count = ((Long) query.uniqueResult()).intValue();
	    	return count;
	}







}
