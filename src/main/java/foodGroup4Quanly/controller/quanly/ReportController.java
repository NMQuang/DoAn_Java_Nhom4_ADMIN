package foodGroup4Quanly.controller.quanly;

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
	
	@RequestMapping("")
	public void demo(@RequestParam(required=false) String type, HttpServletResponse response){
		
		List<Map<String, Object>> data = new ArrayList();
		Map<String, Object> person = new HashMap<>();
		person.put("Name", "Employee Report");
		person.put("Tuoi", 25000);
		data.add(person);
		Map<String, Object> person1 = new HashMap<>();
		person1.put("Name", "Employee Report");
		person1.put("Tuoi", 15000);
		data.add(person1);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("title", "Xin chào");
		JRDataSource datasource = new JRBeanCollectionDataSource(data);
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(getClass().getClassLoader().getResourceAsStream("reports/Blank_A4.jasper"), parameters, datasource);
			jasperExportUtils.export(type, response, jasperPrint);
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
	
	@ExceptionHandler(MyBadRequestException.class)
	public String returnURL(MyBadRequestException ex){
		return "redirect:" + ex.getMessage();
	}
}
