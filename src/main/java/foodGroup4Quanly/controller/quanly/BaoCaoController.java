package foodGroup4Quanly.controller.quanly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import foodGroup4Quanly.service.ChiNhanhService;
import foodGroup4Quanly.service.DanhMucService;

@Controller
@RequestMapping("/quanly/baocao")
public class BaoCaoController {
	@Autowired
	private ChiNhanhService chiNhanhService;
	
	@RequestMapping("/tongdoanhthu")
	public String getTongDoanhThuPage(){
		return "quanly-tong-doanh-thu";
	}
	@RequestMapping("/tongdoanhthuchinhanh")
	public String getTongDoanhThuChiNhanhPage(Model model){
		model.addAttribute("AChiNhanh", chiNhanhService.getListChiNhanh());
		return "quanly-tong-doanh-thu-chi-nhanh";
	}
	@RequestMapping("/tongdonhang")
	public String getTongDonHang(){
		return "quanly-tong-don-hang";
	}
	@RequestMapping("/tongdonhangtheoloai")
	public String getTongDonHangTheoLoai(){
		return "quanly-tong-don-hang-theo-loai";
	}
	@RequestMapping("/tongchiphi")
	public String getTongChiPhi(){
		return "quanly-tong-chi-phi";
	}
	@RequestMapping("/tongchiphichinhanh")
	public String getTongChiPhiChiNhanh(Model model){
		model.addAttribute("AChiNhanh", chiNhanhService.getListChiNhanh());
		return "quanly-tong-chi-phi-chi-nhanh";
	}
	
	@RequestMapping("/tongsoluongmontrongthang")
	public String getTongSoLuongMonTrongThang(Model model){
		model.addAttribute("AChiNhanh", chiNhanhService.getListChiNhanh());
		return "quanly-tong-so-luong-mon-trong-thang";
	}
	
	@RequestMapping("/tongtien_donhang_khach")
	public String getDonHangTongTienKhach(){
		return "quanly-tong-tien-don-hang-khach";
	}
	
	@RequestMapping("/thongkekhachmoi")
	public String getLuongKhachMoi(){
		return "quanly-luong-khach-moi";
	}
}
