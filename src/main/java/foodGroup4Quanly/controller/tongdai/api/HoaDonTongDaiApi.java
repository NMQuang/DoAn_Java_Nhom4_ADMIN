package foodGroup4Quanly.controller.tongdai.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import foodGroup4Quanly.common.state.HinhThucMua;
import foodGroup4Quanly.common.state.HinhThucThanhToan;
import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.pojo.ChiTietHoaDonCustom;
import foodGroup4Quanly.pojo.DonHangTongDai;
import foodGroup4Quanly.service.ChiNhanhService;
import foodGroup4Quanly.service.ChiTietHoaDonService;
import foodGroup4Quanly.service.FoodService;
import foodGroup4Quanly.service.HoadonService;
import foodGroup4Quanly.service.KhachHangService;

@RestController
@RequestMapping("/tongdai/api/hoadon")
public class HoaDonTongDaiApi {

	@Autowired
	private ChiNhanhService chiNhanhService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private HoadonService hoadonService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity taoDonHang(@RequestBody DonHangTongDai donHangTongDai){
		Hoadon hoadon = new Hoadon();
		hoadon.setChinhanh(chiNhanhService.getInfoBranch(donHangTongDai.getId_Chinhanh()));
		hoadon.setDiaChiGiao(donHangTongDai.getDia_chi_nhan());
		hoadon.setHinhThucMua(HinhThucMua.TONG_DAI);
		hoadon.setHinhThucThanhToan(HinhThucThanhToan.TIEN_MAT_KHI_NHAN_HANG);
		hoadon.setHoTenNguoiNhan(donHangTongDai.getHo_ten_nguoi_nhan());
		hoadon.setNgay(new Timestamp(new Date().getTime()));
		hoadon.setSdtNguoiNhan(donHangTongDai.getSdt_nguoi_nhan());
		hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.CHO_CHE_BIEN);
		Set<Chitiethoadon> chitiethoadons = new HashSet<Chitiethoadon>();
		int tongtien = 0;
		for(ChiTietHoaDonCustom cth : donHangTongDai.getListChiTiet()){
			System.out.println(cth.getTong());
			Chitiethoadon cthd = new Chitiethoadon();
			cthd.setSoLuong(cth.getSl());
			cthd.setTongTien(cth.getTong());
			tongtien += cth.getTong();
			Mon mon = foodService.getFood(cth.getId());
			cthd.setMon(mon);
			chitiethoadons.add(cthd);
			cthd.setHoadon(hoadon);
		}
		hoadon.setTongTien(tongtien);
		Khachhang kh = khachHangService.get(donHangTongDai.getSdt_khach().trim());
		if(kh == null){
			kh = new Khachhang();
			kh.setSdt(donHangTongDai.getSdt_khach());
			kh.setTen(donHangTongDai.getTen_khach_hang());
			kh.setNgayTao(new java.sql.Date(new Date().getTime()));
			khachHangService.create(kh);
		}
		hoadon.setChitiethoadons(chitiethoadons);
		hoadon.setKhachhang(kh);
		hoadonService.create(hoadon);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/lay-don-hang-can-confirm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getDonHangChuaXacNhan(){
		List<Hoadon> list = hoadonService.notConfirm();
		for(Hoadon hd : list){
			List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hd.getHoaDonId());
			hd.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
