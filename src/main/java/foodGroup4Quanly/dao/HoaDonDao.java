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
}
