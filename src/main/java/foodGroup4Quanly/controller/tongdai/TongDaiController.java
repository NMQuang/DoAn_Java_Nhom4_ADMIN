package foodGroup4Quanly.controller.tongdai;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;
import foodGroup4Quanly.service.ChiNhanhMonService;
import foodGroup4Quanly.service.ChiNhanhService;
import foodGroup4Quanly.service.ChiTietHoaDonService;
import foodGroup4Quanly.service.DanhMucService;
import foodGroup4Quanly.service.HoadonService;

@Controller
@RequestMapping("/tongdai")
public class TongDaiController {

	@Autowired
	private ChiNhanhService chiNhanhService;
	
	@Autowired
	private DanhMucService danhMucService;
	
	@Autowired
	private ChiNhanhMonService chiNhanhMonService;
	
	@Autowired
	private HoadonService hoadonService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
    @RequestMapping(value = "/chi-tiet-don-hang/{idHoaDon}", method = RequestMethod.GET)
    public String getChiTietDonHang(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hoadon.getHoaDonId());
    	hoadon.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
    	model.addAttribute("hoadon",hoadon );
        return "tongdai-chi-tiet-don-hang";
    }
    
    @RequestMapping(value = "/chi-tiet-don-hang-need-confirm/{idHoaDon}", method = RequestMethod.GET)
    public String getChiTietDonHangCanConfirm(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hoadon.getHoaDonId());
    	hoadon.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
    	model.addAttribute("hoadon",hoadon );
        return "tongdai-chi-tiet-don-hang-can-xac-nhan";
    }

    @RequestMapping(value = "/danh-sach-don-hang", method = RequestMethod.GET)
    public String getDanhSachDonHang(Model model, @RequestParam int index, @RequestParam String type) {
    	
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
    
    @RequestMapping(value = "/duyet-don-hang")
    public String duyetDonHang(Model model) {
    	
        return "tongdai-duyet-don-hang";
    }
    
    @RequestMapping(value = "/hoadon/duyet/{idHoaDon}")
    public String xacNhanDuyet(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null){
    		hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.CHO_CHE_BIEN);
        	hoadonService.update(hoadon);
    	}
        return "redirect:/tongdai/duyet-don-hang";
    }

    @RequestMapping(value = "/hoadon/huy/{idHoaDon}")
    public String khongDuyet(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null)
    		hoadonService.delete(hoadon);
        return "redirect:/tongdai/duyet-don-hang";
    }
}
