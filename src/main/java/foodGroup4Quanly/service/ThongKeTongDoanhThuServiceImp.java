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
public class ThongKeTongDoanhThuServiceImp implements ThongKeTongDoanhThuService {
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
				long previous = (long) kq.get(6).get("value");
				kq.get(6).put("value", previous + listhd.get(i).getTongTien());
			}else{
				long previous = (long) kq.get(day - 2).get("value");
				kq.get(day - 2).put("value", previous + listhd.get(i).getTongTien());
			}
			
		}
		
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuThang(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			record.put("value", 0l);
			kq.add(record);
		}
		c.add(Calendar.MONTH, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime());
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_MONTH);
			long previous = (long) kq.get(day - 1).get("value");
			kq.get(day - 1).put("value", previous + listhd.get(i).getTongTien());
			
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuQuy(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Map<String, Object> record1 = new HashMap<>();
		Map<String, Object> record2 = new HashMap<>();
		Map<String, Object> record3 = new HashMap<>();
		kq.add(record1);
		kq.add(record2);
		kq.add(record3);
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		Date begin1 = c.getTime();
		record1.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
		c.add(Calendar.MONTH, 1);
		Date begin2 = c.getTime();
		record2.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
		c.add(Calendar.MONTH, 1);
		Date begin3 = c.getTime();
		record3.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
		c.add(Calendar.MONTH, 1);
		Date end = c.getTime();
		
		long sum1 = hoaDonDao.getSum(begin1, begin2);
		record1.put("value", sum1);
		long sum2 = hoaDonDao.getSum(begin2, begin3);
		record2.put("value", sum2);
		long sum3 = hoaDonDao.getSum(begin3, end);
		record3.put("value", sum3);
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuNam(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for(int i = 1; i <= 12 ; i++){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + i + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			Date e = c.getTime();
			record.put("value", hoaDonDao.getSum(b, e));
			kq.add(record);
		}
		
		return kq;
	}
}
