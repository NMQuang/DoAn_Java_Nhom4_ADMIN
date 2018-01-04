package foodGroup4Quanly.controller.chinhanh.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import foodGroup4Quanly.common.state.HinhThucMua;
import foodGroup4Quanly.common.state.HinhThucThanhToan;
import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.common.state.TinhTrangThanhToan;
import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.entity.Nhanvien;
import foodGroup4Quanly.pojo.ChiTietHoaDonCustom;
import foodGroup4Quanly.pojo.DonHangDemVe;
import foodGroup4Quanly.service.BanService;
import foodGroup4Quanly.service.ChiTietHoaDonService;
import foodGroup4Quanly.service.FoodService;
import foodGroup4Quanly.service.HoadonService;

@RestController
@RequestMapping("/chinhanh/api/hoadon")
public class HoaDonApi {

	@Autowired
	private HoadonService hoadonService;
	
	@Autowired
	private BanService banService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@RequestMapping(value="/created-on-table", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity taoHoaDon(@RequestParam int idBan, @ModelAttribute("chinhanh") Chinhanh chinhanh, @ModelAttribute("nhanvien") Nhanvien nhanvien){
		Ban b = banService.getInfoBan(idBan);
		if(b == null || b.getTinhTrang() == 1)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		Hoadon hoadon = new Hoadon();
		Ban ban = new Ban();
		ban.setBanId(idBan);
		hoadon.setBan(ban);
		hoadon.setChinhanh(chinhanh);
		hoadon.setHinhThucMua(HinhThucMua.TAI_CHO);
		hoadon.setNgay(new Timestamp(new Date().getTime()));
		hoadon.setHinhThucThanhToan(HinhThucThanhToan.TIEN_MAT_KHI_NHAN_HANG);
		hoadon.setTongTien(0);
		hoadon.setTinhTrangThanhToan(TinhTrangThanhToan.CHUA_THANH_TOAN);
		hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.DANG_CHE_BIEN);
		hoadon.setNhanvien(nhanvien);
		hoadonService.create(hoadon);
		b.setTinhTrang(1);
		banService.update(b);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cancelled-on-table/{idBan}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity cancelled_on_table(@PathVariable int idBan){
		Hoadon hd = hoadonService.getTheLastBillByTableStillCooking(idBan);
		if(hd !=null)
			hoadonService.delete(hd);
		Ban b = banService.getInfoBan(idBan);
		b.setTinhTrang(0);
		banService.update(b);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getBillByTable/{idBan}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getBillByTable(@PathVariable int idBan){
		Hoadon hd = hoadonService.getTheLastBillByTableStillCooking(idBan);
		if(hd !=null){
			List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hd.getHoaDonId());
			hd.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
			return new ResponseEntity<Hoadon> (hd, HttpStatus.OK);
		}
			
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/updateBillDetailsByTable/{idBan}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateBillDetailsByTable(@PathVariable int idBan, @RequestBody List<ChiTietHoaDonCustom> dsChiTiet){
		System.out.println(dsChiTiet.size());
		Hoadon hd = hoadonService.getTheLastBillByTableStillCooking(idBan);
		if(hd == null)
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		Set<Chitiethoadon> chitiethoadons = new HashSet<Chitiethoadon>();
		int tongtien = 0;
		for(ChiTietHoaDonCustom cth : dsChiTiet){
			System.out.println(cth.getTong());
			Chitiethoadon cthd = new Chitiethoadon();
			cthd.setSoLuong(cth.getSl());
			cthd.setTongTien(cth.getTong());
			tongtien += cth.getTong();
			Mon mon = foodService.getFood(cth.getId());
			cthd.setMon(mon);
			chitiethoadons.add(cthd);
			cthd.setHoadon(hd);
		}
		hd.setTongTien(tongtien);
		hd.setChitiethoadons(chitiethoadons);
		hoadonService.update(hd);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createBillGetAway", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createBillGetAway(@RequestBody DonHangDemVe donHangDemVe, @ModelAttribute("chinhanh") Chinhanh chinhanh, @ModelAttribute("nhanvien") Nhanvien nhanvien){
		List<ChiTietHoaDonCustom> dsChiTiet = donHangDemVe.getListChiTiet();
		System.out.println(dsChiTiet.size());
		Hoadon hd = new Hoadon();

		Set<Chitiethoadon> chitiethoadons = new HashSet<Chitiethoadon>();
		int tongtien = 0;
		for(ChiTietHoaDonCustom cth : dsChiTiet){
			System.out.println(cth.getTong());
			Chitiethoadon cthd = new Chitiethoadon();
			cthd.setSoLuong(cth.getSl());
			cthd.setTongTien(cth.getTong());
			tongtien += cth.getTong();
			Mon mon = foodService.getFood(cth.getId());
			cthd.setMon(mon);
			chitiethoadons.add(cthd);
			cthd.setHoadon(hd);
		}
		hd.setTongTien(tongtien);
		hd.setChitiethoadons(chitiethoadons);
		hd.setChinhanh(chinhanh);
		hd.setHinhThucMua(HinhThucMua.MANG_VE);
		hd.setNgay(new Timestamp(new Date().getTime()));
		hd.setHinhThucThanhToan(HinhThucThanhToan.TIEN_MAT_KHI_NHAN_HANG);
		hd.setTinhTrangGiaoHang(TinhTrangGiaoHang.DANG_CHE_BIEN);
		hd.setNhanvien(nhanvien);
		hd.setHoTenNguoiNhan(donHangDemVe.getTen_nguoi_nhan());
		hoadonService.create(hd);
		return new ResponseEntity(HttpStatus.OK);
	}
}
