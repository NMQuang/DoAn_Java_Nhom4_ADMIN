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

import foodGroup4Quanly.common.state.HinhThucMua;
import foodGroup4Quanly.dao.HoaDonDao;
import foodGroup4Quanly.entity.Hoadon;

@Component
@Transactional
public class ThongKeDoanhThuChiNhanhServiceImp implements
		ThongKeDoanhThuChiNhanhService {

	@Autowired
	private HoaDonDao hoaDonDao;

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuNgay(Date date,
			int chinhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String, Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(date, c.getTime(), chinhanh);
		for (int i = 0; i < 24; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i + ":00 -> " + (i + 1) + ":00");
			record.put("web", 0l);
			record.put("mangve", 0l);
			record.put("taicho", 0l);
			record.put("tongdai", 0l);
			record.put("tien", 0l);
			kq.add(record);
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			switch (listhd.get(i).getHinhThucMua()) {
			case HinhThucMua.MANG_VE: {
				long previous = (long) kq.get(hour).get("mangve");
				kq.get(hour).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.ONLINE: {
				long previous = (long) kq.get(hour).get("web");
				kq.get(hour).put("web", previous + 1);
				break;
			}
			case HinhThucMua.TAI_CHO: {
				long previous = (long) kq.get(hour).get("taicho");
				kq.get(hour).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.TONG_DAI: {
				long previous = (long) kq.get(hour).get("tongdai");
				kq.get(hour).put("mangve", previous + 1);
				break;
			}
			}
			long previous = (long) kq.get(hour).get("tien");
			kq.get(hour).put("tien", previous + listhd.get(i).getTongTien());
		}

		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuTuan(Date begin,
			int chinhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.DATE, 7);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime(), chinhanh);
		for (int i = 2; i <= 8; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Thứ " + i);
			if(i ==8)
				record.put("unit","Chủ nhật");
			record.put("web", 0l);
			record.put("mangve", 0l);
			record.put("taicho", 0l);
			record.put("tongdai", 0l);
			record.put("tien", 0l);
			kq.add(record);
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_WEEK);
			int index;
			if(day == Calendar.SUNDAY){
				index = 6;
			}else{
				index = day -2;
			}
			switch (listhd.get(i).getHinhThucMua()) {
			case HinhThucMua.MANG_VE: {
				long previous = (long) kq.get(index).get("mangve");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.ONLINE: {
				long previous = (long) kq.get(index).get("web");
				kq.get(index).put("web", previous + 1);
				break;
			}
			case HinhThucMua.TAI_CHO: {
				long previous = (long) kq.get(index).get("taicho");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.TONG_DAI: {
				long previous = (long) kq.get(index).get("tongdai");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			}
			
			long previous = (long) kq.get(index).get("tien");
			kq.get(index).put("tien", previous + listhd.get(i).getTongTien());
		}
		
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuThang(Date begin,
			int chinhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			record.put("web", 0l);
			record.put("mangve", 0l);
			record.put("taicho", 0l);
			record.put("tongdai", 0l);
			record.put("tien", 0l);
			kq.add(record);
		}
		c.add(Calendar.MONTH, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime(), chinhanh);
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_MONTH);
			int index = day -1;
			switch (listhd.get(i).getHinhThucMua()) {
			case HinhThucMua.MANG_VE: {
				long previous = (long) kq.get(index).get("mangve");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.ONLINE: {
				long previous = (long) kq.get(index).get("web");
				kq.get(index).put("web", previous + 1);
				break;
			}
			case HinhThucMua.TAI_CHO: {
				long previous = (long) kq.get(index).get("taicho");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			case HinhThucMua.TONG_DAI: {
				long previous = (long) kq.get(index).get("tongdai");
				kq.get(index).put("mangve", previous + 1);
				break;
			}
			}
			
			long previous = (long) kq.get(index).get("tien");
			kq.get(index).put("tien", previous + listhd.get(i).getTongTien());
			
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuQuy(Date begin,
			int chinhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		
		for(int i = 1; i <=3; i++){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			record.put("web", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.ONLINE));
			record.put("mangve", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.MANG_VE));
			record.put("taicho", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.TAI_CHO));
			record.put("tongdai", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.TONG_DAI));
			record.put("tien", hoaDonDao.getSum(b, c.getTime()));
			kq.add(record);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDoanhThuNam(Date begin,
			int chinhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for(int i = 1; i <= 12 ; i++){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + i + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			Date e = c.getTime();
			record.put("web", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.ONLINE));
			record.put("mangve", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.MANG_VE));
			record.put("taicho", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.TAI_CHO));
			record.put("tongdai", hoaDonDao.getCountTypeBill(b, c.getTime(), chinhanh, HinhThucMua.TONG_DAI));
			record.put("tien", hoaDonDao.getSum(b, c.getTime()));
			kq.add(record);
		}
		
		return kq;
	}

}
