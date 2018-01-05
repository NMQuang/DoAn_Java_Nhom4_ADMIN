package foodGroup4Quanly.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.HoaDonDao;
import foodGroup4Quanly.dao.HoaDonDaoImp;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;

@Component
@Transactional
public class InHoaDonServiceImp implements InHoaDonService{

	@Autowired
	private HoaDonDao hoaDonDao;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@Override
	public List<Map<String, Object>> inHoaDon(int idHoaDon) {
		List<Map<String, Object>> kq = new ArrayList<Map<String, Object>>();
		Hoadon hoaDon = ((HoaDonDaoImp)hoaDonDao).fetchById(idHoaDon, Hoadon.class);
		if(hoaDon == null) return kq;
		for(Chitiethoadon cthd : chiTietHoaDonService.getByIDHoaDon(hoaDon.getHoaDonId())){
			Map <String, Object> record = new HashMap<String, Object>();
			record.put("Ten_mon_an", cthd.getMon().getTen());
			record.put("So_luong", (long)cthd.getSoLuong());
			record.put("Don_gia", (long)cthd.getTongTien()/ cthd.getSoLuong());
			record.put("Thanh_tien", (long)cthd.getTongTien());
			kq.add(record);
		}
		return kq;
	}
	@Override
	public List<Map<String, Object>> inThucDon(int idHoaDon) {
		List<Map<String, Object>> kq = new ArrayList<Map<String, Object>>();
		Hoadon hoaDon = ((HoaDonDaoImp)hoaDonDao).fetchById(idHoaDon, Hoadon.class);
		if(hoaDon == null) return kq;
		for(Chitiethoadon cthd : chiTietHoaDonService.getByIDHoaDon(hoaDon.getHoaDonId())){
			Map <String, Object> record = new HashMap<String, Object>();
			record.put("Ten_mon_an", cthd.getMon().getTen());
			record.put("So_luong", (long)cthd.getSoLuong());
			kq.add(record);
		}
		return kq;
	}
}
