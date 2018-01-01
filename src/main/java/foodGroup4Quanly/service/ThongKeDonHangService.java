package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeDonHangService {

	List<Map<String, Object>> thongkeTongDonHangNgay(Date date);
	List<Map<String, Object>> thongkeTongDonHangTuan(Date begin);
	List<Map<String, Object>> thongkeTongDonHangThang(Date begin);
	List<Map<String, Object>> thongkeTongDonHangQuy(Date begin);
	List<Map<String, Object>> thongkeTongDonHangNam(Date begin);
}
