package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeKhachHangService {
	List<Map<String, Object>> thongKeKhachTheoThoiGian();
	List<Map<String, Object>> thongKeHoaDon_TienTheoThang(Date begin, String sdt);
	List<Map<String, Object>> thongKeHoaDon_TienTheoFromBeginning(String sdt);
}
