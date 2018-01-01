package foodGroup4Quanly.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ThongKeTongChiPhiService {
	List<Map<String, Object>> thongkeTongChiPhiNgay(Date date);
	List<Map<String, Object>> thongkeTongChiPhiTuan(Date begin);
	List<Map<String, Object>> thongkeTongChiPhiThang(Date begin);
	List<Map<String, Object>> thongkeTongChiPhiQuy(Date begin);
	List<Map<String, Object>> thongkeTongChiPhiNam(Date begin);
}
