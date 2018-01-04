package foodGroup4Quanly.controller.chinhanh;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import foodGroup4Quanly.common.state.TinhTrangThanhToan;
import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.service.BanService;
import foodGroup4Quanly.service.ChiTietHoaDonService;
import foodGroup4Quanly.service.HoadonService;
import foodGroup4Quanly.service.KhachHangService;

@Controller
@RequestMapping(value = "/chinhanh")
public class ChiNhanhDonHangController {

	@Autowired
	private HoadonService hoadonService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private BanService banService;
	
	@RequestMapping(value = "/danhsachdonhang")
	public String getDanhSachDonHang(Model model) {
		return "chinhanh-danh-sach-don-hang";
	}

	@RequestMapping(value = "/chitietdonhang")
	public String getChiTietDonHang(Model model) {
		return "chinhanh-chi-tiet-don-hang";
	}

	@RequestMapping(value = "/thanhtoandonhang/{idDonHang}", method = RequestMethod.GET)
	public String getThanhToanDonHang(Model model, @PathVariable int idDonHang) {
		Hoadon hoadon = hoadonService.getBillById(idDonHang);
		System.out.println(hoadon.getTinhTrangThanhToan() + " " + hoadon.getHoaDonId());
		if (hoadon == null || hoadon.getTinhTrangThanhToan() == TinhTrangThanhToan.DA_THANH_TOAN)
			model.addAttribute("error", "Đơn hàng không tồn tại");
		else{
			System.out.println(hoadon == null);
			List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hoadon.getHoaDonId());
			hoadon.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
			model.addAttribute("hoadon", hoadon);
		}
			
		return "chinhanh-thanh-toan-don-hang";
	}
	
	@RequestMapping(value = "/thanhtoandonhang/{idDonHang}", method = RequestMethod.POST)
	public String thanhToanDonHang(Model model, @PathVariable int idDonHang, @RequestParam String sdt_khach, @RequestParam String ten_khach_hang) {
		Hoadon hoadon = hoadonService.getBillById(idDonHang);
		System.out.println(hoadon.getTinhTrangThanhToan() + " " + hoadon.getHoaDonId());
		if (hoadon == null || hoadon.getTinhTrangThanhToan() == TinhTrangThanhToan.DA_THANH_TOAN)
			return "redirect:/chinhanh/taodonhang/taiquan";
		else{
			if(!sdt_khach.trim().equals("")){
				Khachhang kh = khachHangService.get(sdt_khach.trim());
				if(kh == null){
					kh = new Khachhang();
					kh.setSdt(sdt_khach);
					kh.setTen(ten_khach_hang);
					khachHangService.create(kh);
				}
				hoadon.setKhachhang(kh);
			}
			Ban ban = hoadon.getBan();
			if(ban != null){
				ban.setTinhTrang(0);
				banService.update(ban);
			}
			hoadon.setTinhTrangThanhToan(TinhTrangThanhToan.DA_THANH_TOAN);
			hoadonService.update(hoadon);
		}
			
		return "redirect:/chinhanh/taodonhang/taiquan";
	}
}
