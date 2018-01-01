package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Luongchonhanvien;

public interface LuongChoNhanVienDao {
	List<Luongchonhanvien> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
	long getSum(Date begin, Date end, int ChiNhanh);
	List<Luongchonhanvien> getListIn(Date begin, Date end, int ChiNhanh);
}
