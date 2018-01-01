package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeTongChiPhiChiNhanhService {
	List<Map<String, Object>> thongkeTongChiPhiNgay(Date date, int ChiNhanh);
	List<Map<String, Object>> thongkeTongChiPhiTuan(Date begin, int ChiNhanh);
	List<Map<String, Object>> thongkeTongChiPhiThang(Date begin, int ChiNhanh);
	List<Map<String, Object>> thongkeTongChiPhiQuy(Date begin, int ChiNhanh);
	List<Map<String, Object>> thongkeTongChiPhiNam(Date begin, int ChiNhanh);
	
}
