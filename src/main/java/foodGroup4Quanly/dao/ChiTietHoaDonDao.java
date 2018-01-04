package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Chitiethoadon;

public interface ChiTietHoaDonDao {

	long getSumMon(Date begin, Date end);
	long getSumMon(Date begin, Date end, int ChiNhanh);
	
	List<Chitiethoadon> getByIDHoaDon(int idHoaDon);
}
