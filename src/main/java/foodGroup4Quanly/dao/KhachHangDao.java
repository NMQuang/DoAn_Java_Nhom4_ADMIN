package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.pojo.KhachHangGroup;

public interface KhachHangDao {
	List<KhachHangGroup> getAllGroupByTime();
	Khachhang get(String sdt);
}
