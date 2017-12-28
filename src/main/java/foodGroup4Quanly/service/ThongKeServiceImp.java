package foodGroup4Quanly.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.HoaDonDao;
import foodGroup4Quanly.entity.Hoadon;

@Component
@Transactional
public class ThongKeServiceImp implements ThongKeService {
	@Autowired
	private HoaDonDao hoaDonDao;
	
	

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuNgay(Date date) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(date, c.getTime());
		for (int i = 0; i < 24; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i + ":00 -> " + (i+1) +":00");
			record.put("value", 0l);
			kq.add(record);
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			long previous = (long) kq.get(hour).get("value");
			kq.get(hour).put("value", previous + listhd.get(i).getTongTien());
		}
		
		return kq;
	}
	
	public List<Map<String, Object>> thongkeTongDoanhThuTuan(Date begin){
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.DATE, 7);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime());
		for (int i = 2; i <= 8; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Thứ " + i);
			if(i ==8)
				record.put("unit","Chủ nhật");
			record.put("value", 0l);
			kq.add(record);
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_WEEK);
			if(day == Calendar.SUNDAY){
				long previous = (long) kq.get(7).get("value");
				kq.get(7).put("value", previous + listhd.get(i).getTongTien());
			}else{
				long previous = (long) kq.get(day - 2).get("value");
				kq.get(day - 2).put("value", previous + listhd.get(i).getTongTien());
			}
			
		}
		
		return kq;
	}
}
