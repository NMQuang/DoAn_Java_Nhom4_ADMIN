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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    		int pages = 0;

		if ("tong_dai".equals(type)) {
			model.addAttribute("hoadon", hoadonService.getListHoaDonTongDai(10,begin));
			count = hoadonService.countTongDai();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", type);
		} else if ("mang_ve".equals(type)) {
			model.addAttribute("hoadon", hoadonService.getListHoaDonMangVe(10,begin));
			count = hoadonService.countMangVe();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", type);
		} else {
			model.addAttribute("hoadon", hoadonService.getListHoaDonTaiQuan(10,begin));
			count = hoadonService.countTaiQuan();
			pages = count / 10 + (count %10 == 0 ? 0 : 1);
			model.addAttribute("type", type);
		}
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
			model.addAttribute("error", "ﾄ脆｡n hﾃ�ng khﾃｴng t盻渡 t蘯｡i");
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
			throw new MyBadRequestException("redirect:/chinhanh/taodonhang/taiquan");
		}
		if(hoadon.getBan() != null)
			parameters.put("ban", hoadon.getBan().getTenBan());
		if(hoadon.getKhachhang() != null)
			parameters.put("ten_khach_hang", hoadon.getHoTenNguoiNhan());
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
