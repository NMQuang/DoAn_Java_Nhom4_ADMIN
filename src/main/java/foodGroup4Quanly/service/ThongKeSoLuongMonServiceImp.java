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

import foodGroup4Quanly.dao.ChiTietHoaDonDao;

@Component
@Transactional
public class ThongKeSoLuongMonServiceImp implements ThongKeSoLuongMonService{

	@Autowired
	private ChiTietHoaDonDao chiTietHoaDonDao;
	
	@Override
	public List<Map<String, Object>> thongKeSoLuongMonTheoThang(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date e = c.getTime();
			record.put("value", chiTietHoaDonDao.getSumMon(b, e));
			kq.add(record);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongKeSoLuongMonTheoThang(Date begin,
			int ChiNhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date e = c.getTime();
			record.put("value", chiTietHoaDonDao.getSumMon(b, e, ChiNhanh));
			kq.add(record);
		}
		return kq;
	}

}
