package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeDoanhThuChiNhanhService {
	List<Map<String, Object>> thongkeTongDoanhThuNgay(Date date, int chinhanh);
	List<Map<String, Object>> thongkeTongDoanhThuTuan(Date begin,  int chinhanh);
	List<Map<String, Object>> thongkeTongDoanhThuThang(Date begin, int chinhanh);
	List<Map<String, Object>> thongkeTongDoanhThuQuy(Date begin, int chinhanh);
	List<Map<String, Object>> thongkeTongDoanhThuNam(Date begin, int chinhanh);
}
