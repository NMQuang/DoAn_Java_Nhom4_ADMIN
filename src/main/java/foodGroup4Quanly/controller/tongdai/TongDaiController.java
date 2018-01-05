package foodGroup4Quanly.controller.tongdai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.service.ChiNhanhMonService;
import foodGroup4Quanly.service.ChiNhanhService;
import foodGroup4Quanly.service.DanhMucService;

@Controller
@RequestMapping("/tongdai")
public class TongDaiController {

	@Autowired
	private ChiNhanhService chiNhanhService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private ChiNhanhMonService chiNhanhMonService;
	
    @RequestMapping(value = "/chi-tiet-don-hang", method = RequestMethod.GET)
    public String getChiTietDonHang(Model model) {
        return "tongdai-chi-tiet-don-hang";
    }

    @RequestMapping(value = "/danh-sach-don-hang", method = RequestMethod.GET)
    public String getDanhSachDonHang(Model model) {
        return "tongdai-danh-sach-don-hang";
    }

    @RequestMapping(value = "/tao-don-hang-dien-thoai")
    public String getDonHangDienThoai(Model model) {
    	List<Chinhanh> dsCN = chiNhanhService.getListChiNhanh();
    	model.addAttribute("dsChiNhanh", dsCN);
    	model.addAttribute("dsDM", danhMucService.getAllDanhMuc(true));
    	if(dsCN.size() > 0){
    		model.addAttribute("dsCnMon", chiNhanhMonService.getListChiNhanhMonByChiNhanh(dsCN.get(0).getChiNhanhId()));
    	}
        return "tongdai-tao-don-hang-dien-thoai";
    }

}
