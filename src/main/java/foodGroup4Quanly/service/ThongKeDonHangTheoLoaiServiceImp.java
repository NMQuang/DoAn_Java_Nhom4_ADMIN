package foodGroup4Quanly.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.common.state.HinhThucMua;
import foodGroup4Quanly.dao.HoaDonDao;
import foodGroup4Quanly.entity.Hoadon;

@Component
@Transactional
public class ThongKeDonHangTheoLoaiServiceImp implements ThongKeDonHangTheoLoaiService{

	@Autowired
	private HoaDonDao hoaDonDao;
	
	@Override
	public List<Map<String, Object>> thongkeTongDonHangNgay(Date date) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(date, c.getTime());
		String[] listHT = {HinhThucMua.MANG_VE, HinhThucMua.ONLINE, HinhThucMua.TAI_CHO, HinhThucMua.TONG_DAI};
		for (int i = 0; i < 24; i++) {
			for(int j = 0; j < listHT.length; j++){
				Map<String, Object> record = new HashMap<String, Object>();
				record.put("unit", i + ":00 -> " + (i+1) +":00");
				record.put("typebill", listHT[j]);
				record.put("value", 0l);
				kq.add(record);
			}
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int type = ArrayUtils.indexOf(listHT, listhd.get(i).getHinhThucMua());
			if(type != ArrayUtils.INDEX_NOT_FOUND){
				int index = hour*listHT.length + type;
				long previous = (long) kq.get(index).get("value");
				kq.get(index).put("value", previous + 1);
			}
		}
		
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDonHangTuan(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		c.add(Calendar.DATE, 7);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime());
		String[] listHT = {HinhThucMua.MANG_VE, HinhThucMua.ONLINE, HinhThucMua.TAI_CHO, HinhThucMua.TONG_DAI};
		for (int i = 2; i <= 8; i++) {
			for(int j = 0; j < listHT.length; j++){
				Map<String, Object> record = new HashMap<String, Object>();
				record.put("unit", "Thứ " + i);
				if(i ==8)
					record.put("unit","Chủ nhật");
				record.put("typebill", listHT[j]);
				record.put("value", 0l);
				kq.add(record);
			}
		}
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_WEEK);
			int type = ArrayUtils.indexOf(listHT, listhd.get(i).getHinhThucMua());
			int index = (day-2)*listHT.length + type;
			if(day == Calendar.SUNDAY){
				index = 6*listHT.length + type;
			}
			long previous = (long) kq.get(index).get("value");
			kq.get(index).put("value", previous + 1);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDonHangThang(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		String[] listHT = {HinhThucMua.MANG_VE, HinhThucMua.ONLINE, HinhThucMua.TAI_CHO, HinhThucMua.TONG_DAI};
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			for(int j = 0; j < listHT.length; j++){
				Map<String, Object> record = new HashMap<String, Object>();
				record.put("unit", i/10 + ""+ i%10 + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
				record.put("typebill", listHT[j]);
				record.put("value", 0l);
				kq.add(record);
			}
		}
		c.add(Calendar.MONTH, 1);
		List<Hoadon> listhd = hoaDonDao.getListIn(begin, c.getTime());
		for (int i = 0; i < listhd.size(); i++) {
			c.setTime(listhd.get(i).getNgay());
			int day = c.get(Calendar.DAY_OF_MONTH);
			int type = ArrayUtils.indexOf(listHT, listhd.get(i).getHinhThucMua());
			int index = (day-1)*listHT.length + type;
			long previous = (long) kq.get(index).get("value");
			kq.get(index).put("value", previous + 1);
			
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDonHangQuy(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		String[] listHT = {HinhThucMua.MANG_VE, HinhThucMua.ONLINE, HinhThucMua.TAI_CHO, HinhThucMua.TONG_DAI};
		for(int i = 1; i <=3; i++){
			for(int j = 0; j < listHT.length; j++){
				Map<String, Object> record = new HashMap<>();
				record.put("unit", "Tháng " + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
				Date b = c.getTime();
				c.add(Calendar.MONTH, 1);
				record.put("typebill", listHT[j]);
				record.put("value", hoaDonDao.getCountTypeBill(b, c.getTime(), listHT[j]));
				kq.add(record);
				c.add(Calendar.MONTH, -1);
			}
			c.add(Calendar.MONTH, 1);
		}
		return kq;
	}

	@Override
	public List<Map<String, Object>> thongkeTongDonHangNam(Date begin) {
		List<Map<String, Object>> kq = new ArrayList<Map<String,Object>>();
		Calendar c = Calendar.getInstance();
		c.setTime(begin);
		String[] listHT = {HinhThucMua.MANG_VE, HinhThucMua.ONLINE, HinhThucMua.TAI_CHO, HinhThucMua.TONG_DAI};
		for(int i = 1; i <= 12 ; i++){
			for(int j = 0; j < listHT.length; j++){
				Map<String, Object> record = new HashMap<>();
				record.put("unit", "Tháng " + i + "/" + c.get(Calendar.YEAR));
				Date b = c.getTime();
				c.add(Calendar.MONTH, 1);
				Date e = c.getTime();
				record.put("typebill", listHT[j]);
				record.put("value", hoaDonDao.getCountTypeBill(b, c.getTime(), listHT[j]));
				kq.add(record);
				c.add(Calendar.MONTH, -1);
			}
			c.add(Calendar.MONTH, 1);
		}
		
		return kq;
	}

}
