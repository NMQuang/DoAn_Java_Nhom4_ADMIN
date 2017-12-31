package foodGroup4Quanly.controller.quanly;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import foodGroup4Quanly.common.JasperExportUtils;
import foodGroup4Quanly.common.MyBadRequestException;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.service.ChiNhanhService;
import foodGroup4Quanly.service.ThongKeDoanhThuChiNhanhService;
import foodGroup4Quanly.service.ThongKeDonHangService;
import foodGroup4Quanly.service.ThongKeDonHangTheoLoaiService;
import foodGroup4Quanly.service.ThongKeKhachHangService;
import foodGroup4Quanly.service.ThongKeSoLuongMonService;
import foodGroup4Quanly.service.ThongKeTongChiPhiChiNhanhService;
import foodGroup4Quanly.service.ThongKeTongChiPhiService;
import foodGroup4Quanly.service.ThongKeTongDoanhThuService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private JasperExportUtils jasperExportUtils;
	
	@Autowired
	private ChiNhanhService chiNhanhService;
	
	@Autowired
	private ThongKeTongDoanhThuService thongKeTongDoanhThuService;
	
	@Autowired
	private ThongKeDoanhThuChiNhanhService thongKeTongDoanhThuChiNhanhService;
	
	@Autowired
	private ThongKeDonHangService thongKeDonHangService;
	
	@Autowired
	private ThongKeDonHangTheoLoaiService thongKeDonHangTheoLoaiService;
	
	@Autowired
	private ThongKeTongChiPhiService thongKeTongChiPhiService;
	
	@Autowired
	private ThongKeTongChiPhiChiNhanhService thongKeTongChiPhiChiNhanhService;
	
	@Autowired
	private ThongKeSoLuongMonService thongKeSoLuongMonService;
	
	@Autowired
	private ThongKeKhachHangService thongKeKhachHangService;
	
	@RequestMapping("")
	public void demo(@RequestParam(required=false) String type, HttpServletResponse response){
		
		List<Map<String, Object>> data = new ArrayList();
		Map<String, Object> person = new HashMap<>();
		person.put("time", new Timestamp(1514729050392l));
		person.put("value", 25l);
		data.add(person);
		Map<String, Object> person1 = new HashMap<>();
		person1.put("time", new Timestamp(1510709050392l));
		person1.put("value", 150l);
		data.add(person1);
		Map<String, Object> person2 = new HashMap<>();
		person2.put("time", new Timestamp(1510709050393l));
		person2.put("value", 150l);
		data.add(person2);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("title", "Xin chào");
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/Blank_A4.jasper"), parameters, datasource);
			jasperExportUtils.export("pdf", response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	@RequestMapping("/tongdoanhthu")
	@ResponseBody
	public void getDoanhThuTong(@RequestParam(required=false) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam) throws MyBadRequestException{
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeTongDoanhThuService.thongkeTongDoanhThuNgay(ngay);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeTongDoanhThuService.thongkeTongDoanhThuTuan(c.getTime());
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeTongDoanhThuService.thongkeTongDoanhThuThang(thang);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeTongDoanhThuService.thongkeTongDoanhThuQuy(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeTongDoanhThuService.thongkeTongDoanhThuNam(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongdoanhthu?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeTongDoanhThu.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongdoanhthuchinhanh")
	@ResponseBody
	public void getDoanhThuChiNhanh(@RequestParam(required=false) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam,
			@RequestParam int chinhanh) throws MyBadRequestException{
		
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Chinhanh cn = chiNhanhService.getInfoBranch(chinhanh);
		if(cn == null)
			throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
		parameters.put("title", cn.getTen());
		
		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeTongDoanhThuChiNhanhService.thongkeTongDoanhThuNgay(ngay, chinhanh);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeTongDoanhThuChiNhanhService.thongkeTongDoanhThuTuan(c.getTime(), chinhanh);
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeTongDoanhThuChiNhanhService.thongkeTongDoanhThuThang(thang, chinhanh);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeTongDoanhThuChiNhanhService.thongkeTongDoanhThuQuy(c.getTime(), chinhanh);
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeTongDoanhThuChiNhanhService.thongkeTongDoanhThuNam(c.getTime(), chinhanh);
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongdoanhthuchinhanh?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeDoanhThuChiNhanh.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongdonhang")
	@ResponseBody
	public void getTongDonHang(@RequestParam(required=true) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam) throws MyBadRequestException{
		
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		if(!("png".equals(format) || "pdf".equals(format) || "xlsx".equals(format)))
			throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeDonHangService.thongkeTongDonHangNgay(ngay);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeDonHangService.thongkeTongDonHangTuan(c.getTime());
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeDonHangService.thongkeTongDonHangThang(thang);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeDonHangService.thongkeTongDonHangQuy(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeDonHangService.thongkeTongDonHangNam(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongdonhang?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeTongDonHang.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongdonhangtheoloai")
	@ResponseBody
	public void getTongDonHangTheoLoai(@RequestParam(required=true) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam) throws MyBadRequestException{
		
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		if(!("png".equals(format) || "pdf".equals(format) || "xlsx".equals(format)))
			throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeDonHangTheoLoaiService.thongkeTongDonHangNgay(ngay);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeDonHangTheoLoaiService.thongkeTongDonHangTuan(c.getTime());
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeDonHangTheoLoaiService.thongkeTongDonHangThang(thang);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeDonHangTheoLoaiService.thongkeTongDonHangQuy(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeDonHangTheoLoaiService.thongkeTongDonHangNam(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongdonhangtheoloai?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeTongDonHangTheoLoai.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongchiphi")
	@ResponseBody
	public void getTongChiPhi(@RequestParam(required=true) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam) throws MyBadRequestException{
		
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeTongChiPhiService.thongkeTongChiPhiNgay(ngay);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeTongChiPhiService.thongkeTongChiPhiTuan(c.getTime());
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeTongChiPhiService.thongkeTongChiPhiThang(thang);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeTongChiPhiService.thongkeTongChiPhiQuy(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeTongChiPhiService.thongkeTongChiPhiNam(c.getTime());
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongchiphi?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeTongChiPhi.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongchiphichinhanh")
	@ResponseBody
	public void getTongChiPhiChiNhanh(@RequestParam(required=true) String format, @RequestParam String type, HttpServletResponse response,
			@RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date ngay, @RequestParam(required = false)@DateTimeFormat(pattern="dd-MM-yyyy") Date tuan, @RequestParam(required = false)@DateTimeFormat(pattern="MM-yyyy") Date thang, @RequestParam(required = false) Integer quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam_quy,
			@RequestParam(required = false)@DateTimeFormat(pattern="yyyy") Date nam,
			@RequestParam int chinhanh) throws MyBadRequestException{
		
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		Chinhanh cn = chiNhanhService.getInfoBranch(chinhanh);
		if(cn == null)
			throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
		parameters.put("title", cn.getTen());
		
		switch (type) {
		case "option-ngay":
			if(ngay == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
			parameters.put("type", "Ngày: " + dateFormat.format(ngay));
			data = thongKeTongChiPhiChiNhanhService.thongkeTongChiPhiNgay(ngay, chinhanh);
			break;
		case "option-tuan":{
			if(tuan == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(tuan);
			int dow = c.get(Calendar.DAY_OF_WEEK);
			if(dow == Calendar.SUNDAY)
				dow = 8;
			c.add(Calendar.DATE, 2 - dow);//chuyển về ngày đầu tuần
			data = thongKeTongChiPhiChiNhanhService.thongkeTongChiPhiTuan(c.getTime(), chinhanh);
			Date begin = c.getTime();
			c.add(Calendar.DATE, 6); // chuyển về cuối tuần để hiển thị tiêu đề
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tuần: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-thang":{
			if(thang == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(thang);
			data = thongKeTongChiPhiChiNhanhService.thongkeTongChiPhiThang(thang, chinhanh);
			Date begin = c.getTime();
			c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
			System.out.println(c.getTime());
			Date end = c.getTime();
			parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
			break;
		}
		case "option-quy":{
			if(quy == null || quy < 1 || quy >4 || nam_quy == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam_quy);
			if(quy == 1)
				c.set(Calendar.MONTH, 0);// tháng bắt đầu từ 0 => tháng 1
			if(quy == 2)
				c.set(Calendar.MONTH, 3);
			if(quy == 3)
				c.set(Calendar.MONTH, 6);
			if(quy == 4)
				c.set(Calendar.MONTH, 9);
			data = thongKeTongChiPhiChiNhanhService.thongkeTongChiPhiQuy(c.getTime(), chinhanh);
			System.out.println(c.getTime());
			parameters.put("type", "Quý " + quy + " năm " + c.get(Calendar.YEAR));
			break;
		}
		case "option-nam":{
			if(nam == null)
				throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
			Calendar c = Calendar.getInstance();
			c.setTime(nam);
			data = thongKeTongChiPhiChiNhanhService.thongkeTongChiPhiNam(c.getTime(), chinhanh);
			System.out.println(c.getTime());
			parameters.put("type", "Năm: " + c.get(Calendar.YEAR));
			break;
		}
		default:
			throw  new MyBadRequestException("/quanly/baocao/tongchiphichinhanh?error=");
		}
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeTongChiPhiChiNhanh.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/tongsoluongmontrongthang")
	@ResponseBody
	public void getTongSoLuongMonBanTrongThang(HttpServletResponse response, @RequestParam(required = false) @DateTimeFormat(pattern = "MM-yyyy") Date thang, @RequestParam(defaultValue="-1") Integer chinhanh,
			@RequestParam(required=true) String format) throws MyBadRequestException{
		if(thang == null)
			throw  new MyBadRequestException("/quanly/baocao/tongsoluongmontrongthang?error=");
		Map<String, Object> parameters = new HashMap<>();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		if(chinhanh == -1){// thong ke cho tong
			data = thongKeSoLuongMonService.thongKeSoLuongMonTheoThang(thang);
		}else{
			Chinhanh cn = chiNhanhService.getInfoBranch(chinhanh);
			
			if(cn == null)
				throw  new MyBadRequestException("/quanly/baocao/tongsoluongmontrongthang?error=");
			parameters.put("title", cn.getTen());
			data = thongKeSoLuongMonService.thongKeSoLuongMonTheoThang(thang, chinhanh);
		}
		Calendar c = Calendar.getInstance();
		c.setTime(thang);
		Date begin = c.getTime();
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		System.out.println(c.getTime());
		Date end = c.getTime();
		parameters.put("type", "Tháng: " + dateFormat.format(begin) + " đến " + dateFormat.format(end));
		
		if(format.equals("png") || format.equals("xlsx"))
			parameters.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE);
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			if(chinhanh == -1)
				jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeLuongMonBan.jasper"), parameters, datasource);
			else
				jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeLuongMonBanChiNhanh.jasper"), parameters, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/thongkekhachmoi")
	@ResponseBody
	public void getLuongKhachMoi(@RequestParam(required=false) String format, HttpServletResponse response){
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		data = thongKeKhachHangService.thongKeKhachTheoThoiGian();
		
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/ThongKeLuongKhach.jasper"), null, datasource);
			jasperExportUtils.export(format, response, jasperPrint);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@ExceptionHandler(MyBadRequestException.class)
	public String returnURL(MyBadRequestException ex){
		return "redirect:" + ex.getMessage();
	}
}
