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
}
