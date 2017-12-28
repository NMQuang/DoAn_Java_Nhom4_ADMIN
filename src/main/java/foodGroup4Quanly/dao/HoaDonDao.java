package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Hoadon;

public interface HoaDonDao {
	List<Hoadon> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
}
