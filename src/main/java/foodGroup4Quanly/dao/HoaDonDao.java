package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Hoadon;

public interface HoaDonDao {
	List<Hoadon> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
	long getCount(Date begin, Date end);

	List<Hoadon> getListIn(Date begin, Date end, int chinhanh);
	long getSum(Date begin, Date end, int chinhanh);
	long getCountTypeBill(Date begin, Date end, int chinhanh, String loai);
	long getCountTypeBill(Date begin, Date end, String loai);

	long getSum(Date begin, Date end, String sdt);
	long getCount(Date begin, Date end, String sdt);

	Hoadon getTheLastBillByTableStillCooking(int idBan);
	List<Hoadon> getListHoaDonTaiQuan(int maxResult, int begin);
	List<Hoadon> getListHoaDonTongDai(int maxResult, int begin);
	List<Hoadon> getListHoaDonMangVe(int maxResult, int begin);
	int countTongDai();
	int countTaiQuan();
	int countMangVe();
	
	List<Hoadon> notConfirm();
}
