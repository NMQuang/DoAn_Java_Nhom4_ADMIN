package foodGroup4Quanly.controller.chinhanh;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.util.Calendar;

import foodGroup4Quanly.common.JasperExportUtils;
import foodGroup4Quanly.common.MyBadRequestException;
import foodGroup4Quanly.common.state.TinhTrangGiaoHang;
import foodGroup4Quanly.common.state.TinhTrangThanhToan;
import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chitiethoadon;
import foodGroup4Quanly.entity.Hoadon;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.service.BanService;
import foodGroup4Quanly.service.ChiTietHoaDonService;
import foodGroup4Quanly.service.HoadonService;
import foodGroup4Quanly.service.InHoaDonService;
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

	@Autowired
	private JasperExportUtils jasperExportUtils;

	@Autowired
	private InHoaDonService inHoaDonService;

	@RequestMapping(value = "/danhsachdonhang")
	public String getDanhSachDonHang(Model model, @RequestParam(value = "type",required=false) String type, @RequestParam(required= false) Integer index) {

		int begin;
		int id = 1;
		if (index == null || index < 1) {
			begin = 0;
		} else {
			id = index;
			begin = 10 * (id - 1);
		}
		int count = 0;
    	int pages = 1;

		if ("tai_cho".equals(type)) {
			model.addAttribute("hoadon", hoadonService.getListHoaDonTaiQuan(10,begin));
			count = hoadonService.countTaiQuan();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", type);
		} else if ("mang_ve".equals(type)) {
			model.addAttribute("hoadon", hoadonService.getListHoaDonMangVe(10,begin));
			count = hoadonService.countMangVe();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", type);
		} else {
			model.addAttribute("hoadon", hoadonService.getListHoaDonTongDai(10,begin));
			count = hoadonService.countTongDai();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", "tong_dai");
		}
		model.addAttribute("index", id);
		model.addAttribute("pages", pages);
		return "chinhanh-danh-sach-don-hang";
	}

	@RequestMapping(value = "/chitietdonhang/{idHoaDon}", method = RequestMethod.GET)
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
		return "chinhanh-chi-tiet-don-hang";
	}
	@RequestMapping(value = "/chitietdonhang/{idHoaDon}", method = RequestMethod.POST)
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
        return "redirect:/chinhanh/chitietdonhang/" + hoadon.getHoaDonId();
    }
	@RequestMapping(value = "/xoa/{idHoaDon}")
    public String xoa(Model model, @PathVariable int idHoaDon) {
    	Hoadon hoadon = hoadonService.getBillById(idHoaDon);
    	if(hoadon != null){
    		System.out.println(hoadon.getBan());
    		if(hoadon.getBan() != null){
    			System.out.println(hoadon.getBan().getBanId());
    			Hoadon h = hoadonService.getTheLastBillByTableStillCooking(hoadon.getBan().getBanId());
    			System.out.println(h);
    			if(h != null && h.getHoaDonId() == idHoaDon){
    				Ban b = banService.getInfoBan(hoadon.getBan().getBanId());
    				System.out.println(b.getBanId());
    				b.setTinhTrang(0);
    				banService.update(b);
    			}
    		}
    		hoadonService.delete(hoadon);
    	}
        return "redirect:/chinhanh/danhsachdonhang";
    }
	@RequestMapping(value = "/thanhtoandonhang/{idDonHang}", method = RequestMethod.GET)
	public String getThanhToanDonHang(Model model, @PathVariable int idDonHang) {
		Hoadon hoadon = hoadonService.getBillById(idDonHang);
		if (hoadon == null || hoadon.getTinhTrangThanhToan() == TinhTrangThanhToan.DA_THANH_TOAN)
			model.addAttribute("error", "Hóa đơn này không tồn tại");
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
					kh.setNgayTao(new java.sql.Date(new Date().getTime()));
					khachHangService.create(kh);
				}
				hoadon.setKhachhang(kh);
				hoadon.setSdtNguoiNhan(kh.getSdt());
				hoadon.setHoTenNguoiNhan(kh.getTen());
			}
			Ban ban = hoadon.getBan();
			if(ban != null){
				ban.setTinhTrang(0);
				banService.update(ban);
			}
			
			hoadon.setTinhTrangThanhToan(TinhTrangThanhToan.DA_THANH_TOAN);
			hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.DA_GIAO_HANG);
			hoadon.setNgayTraTien(new Timestamp(new Date().getTime()));
			hoadonService.update(hoadon);
		}

		return "redirect:/chinhanh/inhoadon/" + idDonHang;
	}

	@RequestMapping("/inhoadon/{idHoaDon}")
	@ResponseBody
	public void inHoaDon(HttpServletResponse response, @PathVariable int idHoaDon) throws MyBadRequestException{
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Hoadon hoadon = hoadonService.getBillById(idHoaDon);
		if(hoadon == null){
			throw new MyBadRequestException("redirect:/chinhanh/taodonhang/taiquan");
		}
		if(hoadon.getBan() != null)
			parameters.put("ban", hoadon.getBan().getTenBan());
		if(hoadon.getKhachhang() != null)
			parameters.put("ten_khach_hang", hoadon.getKhachhang().getTen());
		parameters.put("ma_hoa_don", hoadon.getHoaDonId() + "");
		parameters.put("tong_tien", (long)hoadon.getTongTien());
		parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		data = inHoaDonService.inHoaDon(idHoaDon);
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/HoaDon.jasper"), parameters, datasource);
			jasperExportUtils.export("pdf", response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/chuyendonhangxuongbep/{idHoaDon}")
	@ResponseBody
	public void chuyenDonHangXuongBep(HttpServletResponse response, @PathVariable int idHoaDon) throws MyBadRequestException{
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Hoadon hoadon = hoadonService.getBillById(idHoaDon);
		hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.DANG_CHE_BIEN);
		if(hoadon == null || hoadon.getTinhTrangThanhToan() == TinhTrangThanhToan.DA_THANH_TOAN){
			if(hoadon != null && hoadon.getTinhTrangThanhToan() == TinhTrangThanhToan.DA_THANH_TOAN)
			{
				hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.DA_GIAO_HANG);
				hoadonService.update(hoadon);
			}
			throw new MyBadRequestException("redirect:/chinhanh/taodonhang/taiquan");
		}
		if(hoadon.getBan() != null)
			parameters.put("ban", hoadon.getBan().getTenBan());
		if(hoadon.getKhachhang() != null)
			parameters.put("ten_khach_hang", hoadon.getHoTenNguoiNhan());
		hoadon.setTinhTrangGiaoHang(TinhTrangGiaoHang.DANG_CHE_BIEN);
		hoadonService.update(hoadon);
		parameters.put("ma_hoa_don", hoadon.getHoaDonId() + "");
		parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		data = inHoaDonService.inHoaDon(idHoaDon);
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/DemXuongBep.jasper"), parameters, datasource);
			jasperExportUtils.export("pdf", response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ExceptionHandler(MyBadRequestException.class)
	public String handleError(MyBadRequestException ex){
		return ex.getMessage();
	}
}
