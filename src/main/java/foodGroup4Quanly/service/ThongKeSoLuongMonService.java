package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeSoLuongMonService {
	List<Map<String, Object>> thongKeSoLuongMonTheoThang(Date begin);
	List<Map<String, Object>> thongKeSoLuongMonTheoThang(Date begin, int ChiNhanh);
}
