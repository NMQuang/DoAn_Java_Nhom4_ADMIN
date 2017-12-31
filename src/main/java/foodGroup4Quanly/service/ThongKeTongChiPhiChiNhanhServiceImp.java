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

import foodGroup4Quanly.dao.ChiPhiNgayDao;
import foodGroup4Quanly.dao.LuongChoNhanVienDao;
import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.entity.Chiphingay;
import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.Tienthuenha;

@Component
@Transactional
public class ThongKeTongChiPhiChiNhanhServiceImp implements ThongKeTongChiPhiChiNhanhService{
	@Autowired
	private ChiPhiNgayDao chiPhiNgayDao;
	
	@Autowired
	private LuongChoNhanVienDao luongChoNhanVienDao;
	
	@Autowired
	private TienThueNhaDao tienThueNhaDao;
	
	@Override
	public List<Map<String, Object>> thongkeTongChiPhiNgay(Date date,
			int ChiNhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		for (int i = 0; i < 24; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i + ":00 -> " + (i+1) +":00");
			record.put("value", 0l);
			kq.add(record);
		}
		List<Chiphingay> listcpn = chiPhiNgayDao.getListIn(date, c.getTime(),ChiNhanh);
		List<Luongchonhanvien> listlcnv = luongChoNhanVienDao.getListIn(date, c.getTime(),ChiNhanh);
		List<Tienthuenha> listttn = tienThueNhaDao.getListIn(date, c.getTime(),ChiNhanh);
		
		for (int i = 0; i < listcpn.size(); i++) {
			c.setTime(listcpn.get(i).getNgay());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			long previous = (long) kq.get(hour).get("value");
			kq.get(hour).put("value", previous + listcpn.get(i).getTien());
		}
		for (int i = 0; i < listlcnv.size(); i++) {
			c.setTime(listlcnv.get(i).getNgay());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			long previous = (long) kq.get(hour).get("value");
			kq.get(hour).put("value", previous + listlcnv.get(i).getTien());
		}
		for (int i = 0; i < listttn.size(); i++) {
			c.setTime(listttn.get(i).getNgayChi());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			long previous = (long) kq.get(hour).get("value");
			kq.get(hour).put("value", previous + listttn.get(i).getTien());
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongChiPhiTuan(Date begin,
			int ChiNhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.DATE, 7);
		for (int i = 2; i <= 8; i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Thứ " + i);
			if(i ==8)
				record.put("unit","Chủ nhật");
			record.put("value", 0l);
			kq.add(record);
		}
		List<Chiphingay> listcpn = chiPhiNgayDao.getListIn(begin, c.getTime(),ChiNhanh);
		List<Luongchonhanvien> listlcnv = luongChoNhanVienDao.getListIn(begin, c.getTime(),ChiNhanh);
		List<Tienthuenha> listttn = tienThueNhaDao.getListIn(begin, c.getTime(),ChiNhanh);
		for (int i = 0; i < listcpn.size(); i++) {
			c.setTime(listcpn.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_WEEK);
			int index;
			if(day == Calendar.SUNDAY){
				index = 6;
			}else{
				index = day -2;
			}
			long previous = (long) kq.get(index).get("value");
			kq.get(index).put("value", previous + listcpn.get(i).getTien());
		}
		for (int i = 0; i < listlcnv.size(); i++) {
			c.setTime(listlcnv.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_WEEK);
			int index;
			if(day == Calendar.SUNDAY){
				index = 6;
			}else{
				index = day -2;
			}
			long previous = (long) kq.get(index).get("value");
			kq.get(index).put("value", previous + listlcnv.get(i).getTien());
		}
		for (int i = 0; i < listttn.size(); i++) {
			c.setTime(listttn.get(i).getNgayChi());
			int day = c.get(Calendar.DAY_OF_WEEK);
			int index;
			if(day == Calendar.SUNDAY){
				index = 6;
			}else{
				index = day -2;
			}
			long previous = (long) kq.get(index).get("value");
			kq.get(index).put("value", previous + listttn.get(i).getTien());
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongChiPhiThang(Date begin,
			int ChiNhanh) {
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
		List<Chiphingay> listcpn = chiPhiNgayDao.getListIn(begin, c.getTime(),ChiNhanh);
		List<Luongchonhanvien> listlcnv = luongChoNhanVienDao.getListIn(begin, c.getTime(),ChiNhanh);
		List<Tienthuenha> listttn = tienThueNhaDao.getListIn(begin, c.getTime(),ChiNhanh);
		
		for (int i = 0; i < listcpn.size(); i++) {
			c.setTime(listcpn.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_MONTH);
			long previous = (long) kq.get(day-1).get("value");
			kq.get(day-1).put("value", previous + listcpn.get(i).getTien());
		}
		for (int i = 0; i < listlcnv.size(); i++) {
			c.setTime(listlcnv.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_MONTH);
			long previous = (long) kq.get(day-1).get("value");
			kq.get(day-1).put("value", previous + listlcnv.get(i).getTien());
		}
		for (int i = 0; i < listttn.size(); i++) {
			c.setTime(listttn.get(i).getNgayChi());
			int day = c.get(Calendar.DAY_OF_MONTH);
			long previous = (long) kq.get(day-1).get("value");
			kq.get(day-1).put("value", previous + listttn.get(i).getTien());
		}
		
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongChiPhiQuy(Date begin,
			int ChiNhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		
		for(int i = 1; i <=3; i++){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			long value = chiPhiNgayDao.getSum(b, c.getTime(),ChiNhanh) + luongChoNhanVienDao.getSum(b, c.getTime(),ChiNhanh) + tienThueNhaDao.getSum(b, c.getTime(),ChiNhanh);
			record.put("value", value);
			kq.add(record);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongChiPhiNam(Date begin,
			int ChiNhanh) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for(int i = 1; i <= 12 ; i++){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + i + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			long value = chiPhiNgayDao.getSum(b, c.getTime(),ChiNhanh) + luongChoNhanVienDao.getSum(b, c.getTime(),ChiNhanh) + tienThueNhaDao.getSum(b, c.getTime(),ChiNhanh);
			record.put("value", value);
			kq.add(record);
		}
		
		return kq;
	}

	

}
