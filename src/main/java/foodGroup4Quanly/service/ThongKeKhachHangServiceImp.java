package foodGroup4Quanly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.KhachHangDao;
import foodGroup4Quanly.pojo.KhachHangGroup;

@Component
@Transactional
public class ThongKeKhachHangServiceImp implements ThongKeKhachHangService{

	@Autowired
	private KhachHangDao khachHangDao;
	
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

}
