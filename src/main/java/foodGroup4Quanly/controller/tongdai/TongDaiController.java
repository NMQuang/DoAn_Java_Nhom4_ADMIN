package foodGroup4Quanly.controller.tongdai;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.icu.util.Calendar;

import foodGroup4Quanly.common.state.HinhThucMua;
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
	
    @RequestMapping(value = "/hoadon/chi-tiet-don-hang/{idHoaDon}", method = RequestMethod.GET)
    public String getChiTietDonHang(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null){
	    	List<Chitiethoadon> cthdlist = chiTietHoaDonService.getByIDHoaDon(hoadon.getHoaDonId());
	    	hoadon.setChitiethoadons(new HashSet<Chitiethoadon>(cthdlist));
	    	if(hoadon.getThoiGianGiaoDuKien() != null){
	    		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	    		Date d = new Date(hoadon.getThoiGianGiaoDuKien().getTime());
	    		model.addAttribute("thoi_gian", format.format(d));
	    	}
    	}
    	model.addAttribute("hoadon",hoadon );
        return "tongdai-chi-tiet-don-hang";
    }
    @RequestMapping(value = "/hoadon/chi-tiet-don-hang/{idHoaDon}", method = RequestMethod.POST)
    public String updateChiTietDonHang(Model model, @PathVariable int idHoaDon, @RequestParam int tinh_trang_don_hang, @RequestParam(required = false) @DateTimeFormat(pattern ="HH:mm") Date thoi_gian_giao) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null){
	    	hoadon.setTinhTrangGiaoHang(tinh_trang_don_hang);
	    	if(thoi_gian_giao != null){
	    		Calendar c = Calendar.getInstance();
	    		c.setTime(new Date());
	    		Calendar c1 = Calendar.getInstance();
	    		c1.setTime(thoi_gian_giao);
	    		c.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY));
	    		c.set(Calendar.MINUTE, c1.get(Calendar.MINUTE));
	    		hoadon.setThoiGianGiaoDuKien(new Timestamp(c.getTimeInMillis()));
	    	}
    	}
    	hoadonService.update(hoadon);
        return "redirect:/tongdai/hoadon/chi-tiet-don-hang/" + hoadon.getHoaDonId();
    }
    
    @RequestMapping(value = "/hoadon/xoa/{idHoaDon}")
    public String xoa(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null)
    		hoadonService.delete(hoadon);
        return "redirect:/tongdai/danh-sach-don-hang";
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
    public String getDanhSachDonHang(Model model, @RequestParam(required= false) Integer index, @RequestParam(required= false) String type) {
    	int begin; 
		int id = 1;
		if(index == null || index < 1)
			begin = 0;
		else
			id = index;
		begin = 12 * (id - 1);
    	if("option-don-hang-online-tong-dai".equals(type)){
    		int count = (int) hoadonService.getCount(HinhThucMua.ONLINE);
    		int pages = count / 12 + (count %12 == 0 ? 0 : 1);
    		List<Hoadon> dsHoaDon = hoadonService.getlist(HinhThucMua.ONLINE, begin, 12);
    		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("listhd", dsHoaDon);
    		model.addAttribute("type", type);
    	}else{
    		int count = (int) hoadonService.getCount(HinhThucMua.TONG_DAI);
    		int pages = count / 12 + (count %12 == 0 ? 0 : 1);
    		List<Hoadon> dsHoaDon = hoadonService.getlist(HinhThucMua.TONG_DAI, begin, 12);
    		System.out.println(dsHoaDon.size());
    		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("listhd", dsHoaDon);
    		model.addAttribute("type", type);
    	}
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
