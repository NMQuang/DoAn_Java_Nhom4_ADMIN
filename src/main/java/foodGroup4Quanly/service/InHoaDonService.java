package foodGroup4Quanly.service;

import java.util.List;
import java.util.Map;

public interface InHoaDonService {
	List<Map<String, Object>> inHoaDon(int idHoaDon);
	List<Map<String, Object>> inThucDon(int idHoaDon);
}
