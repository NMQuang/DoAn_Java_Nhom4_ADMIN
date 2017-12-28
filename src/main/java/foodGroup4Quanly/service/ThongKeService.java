package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeService {
	List<Map<String, Object>> thongkeTongDoanhThuNgay(Date date);
	List<Map<String, Object>> thongkeTongDoanhThuTuan(Date begin);
	List<Map<String, Object>> thongkeTongDoanhThuThang(Date begin);
	List<Map<String, Object>> thongkeTongDoanhThuQuy(Date begin);
	List<Map<String, Object>> thongkeTongDoanhThuNam(Date begin);
}
