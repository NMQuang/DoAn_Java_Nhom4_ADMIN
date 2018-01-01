package foodGroup4Quanly.dao;

import java.util.Date;

public interface ChiTietHoaDonDao {

	long getSumMon(Date begin, Date end);
	long getSumMon(Date begin, Date end, int ChiNhanh);
}
