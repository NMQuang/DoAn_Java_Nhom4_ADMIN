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
import foodGroup4Quanly.dao.KhachHangDao;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.pojo.KhachHangGroup;

@Component
@Transactional
public class ThongKeKhachHangServiceImp implements ThongKeKhachHangService{

	@Autowired
	private KhachHangDao khachHangDao;
	
	@Autowired
	private HoaDonDao hoaDonDao;
	
	@Override
	public List<Map<String, Object>> thongKeKhachTheoThoiGian() {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		for(KhachHangGroup kh : khachHangDao.getAllGroupByTime()){
			Map<String, Object> record = new HashMap<String, Object>();
			record.put("time", kh.getNgayTao());
			record.put("value", kh.getSoLuong());
			kq.add(record);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongKeHoaDon_TienTheoThang(Date begin,
			String sdt) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			Map<String, Object> record = new HashMap<>();
			record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.DAY_OF_MONTH, 1);
			Date e = c.getTime();
			record.put("donhang", hoaDonDao.getCount(b, e, sdt));
			record.put("tien", hoaDonDao.getSum(b, e, sdt));
			kq.add(record);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongKeHoaDon_TienTheoFromBeginning(
			String sdt) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Khachhang kh = khachHangDao.get(sdt);
		Calendar c = Calendar.getInstance();
		c.setTime(kh.getNgayTao());
		c.set(Calendar.DAY_OF_MONTH, 0);
		
		while(c.getTime().before(new Date())){
			Map<String, Object> record = new HashMap<>();
			record.put("unit", "Tháng " + (c.get(Calendar.MONTH)+1) + "/" + c.get(Calendar.YEAR));
			Date b = c.getTime();
			c.add(Calendar.MONTH, 1);
			Date e = c.getTime();
			record.put("donhang", hoaDonDao.getCount(b, e, sdt));
			record.put("tien", hoaDonDao.getSum(b, e, sdt));
			kq.add(record);
		}
		return kq;
	}

	

}
