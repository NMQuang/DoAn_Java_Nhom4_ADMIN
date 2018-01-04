package foodGroup4Quanly.controller.quanly;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import foodGroup4Quanly.common.MonValidator;
import foodGroup4Quanly.entity.Chinhanhmon;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.service.ChiNhanhMonService;
import foodGroup4Quanly.service.DanhMucService;
import foodGroup4Quanly.service.FoodService;

@Controller
@RequestMapping("/quanly")
public class QuanlyMonanController {

	final String UPLOAD_DIRECTORY = "resources/images/mon-an";
	@Autowired
	ServletContext context;
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	MonValidator monValidator;
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	ChiNhanhMonService chiNhanhMonService;
	
    @RequestMapping(value = "/monan", method = RequestMethod.GET)
    public String getListMonan(Model model, @RequestParam(required=false) String type, @RequestParam(required= false) Integer index) {
    	int begin; 
		int id = 1;
		if(index == null || index < 1)
			begin = 0;
		else
			id = index;
		begin = 12 * (id - 1);
    	if("deleted".equals(type)){
    		int count = foodService.getCountFood(false);
    		int pages = count / 12 + (count %12 == 0 ? 0 : 1);
    		List<Mon> dsMon = foodService.getList(12, begin, false);
    		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("listmon", dsMon);
    		model.addAttribute("type", type);
    	}else{
    		int count = foodService.getCountFood(true);
    		int pages = count / 12 + (count %12 == 0 ? 0 : 1);
    		List<Mon> dsMon = foodService.getList(12, begin, true);
    		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("listmon", dsMon);
    		model.addAttribute("type", type);
    	}
    	System.out.println(id);
        return "quanly-list-mon-an";
    }

    @RequestMapping(value = "/monan/{idMonan}", method = RequestMethod.GET)
    public String getChitietMonan(Model model, @PathVariable("idMonan") int idMonan) {
    	model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    	model.addAttribute("mon", foodService.getFood(idMonan));
    	model.addAttribute("listchinhanh", chiNhanhMonService.getListChiNhanhMonByMon(idMonan));
        return "quanly-chi-tiet-mon-an";
    }
    
    @RequestMapping(value = "/monan/{idMonan}", method = RequestMethod.POST)
    public String updateChitietMonan(Model model, @PathVariable("idMonan") int idMonan, @RequestParam("hinhanh") MultipartFile file, @ModelAttribute("mon")   Mon mon, BindingResult result) {
    	Mon m = foodService.getFood(idMonan);
    	if(!file.isEmpty()){
    		try{
    		byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String uploadPath = context.getRealPath("") + File.separator
					+ UPLOAD_DIRECTORY;
			File dir = new File(uploadPath);

			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location="
					+ serverFile.getAbsolutePath());
			String filepath = "/" + UPLOAD_DIRECTORY + "/"
					+ file.getOriginalFilename();
			m.setHinhAnh(file.getOriginalFilename());
    		}catch(Exception e){
    			
    		}
    	}
    	mon.setHinhAnh(m.getHinhAnh());
    	monValidator.validate(mon, result);
    	if(result.hasErrors()){
    		model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    		return "quanly-chi-tiet-mon-an";
    	}
    	m.setDanhmuc(mon.getDanhmuc());
    	m.setDonViTinh(mon.getDonViTinh());
    	m.setMoTa(mon.getMoTa());
    	m.setTen(mon.getTen());
    	
    	foodService.update(m);
    	
    	model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    	model.addAttribute("mon", foodService.getFood(idMonan));
        return "quanly-chi-tiet-mon-an";
    }
    
    @RequestMapping(value = "/monan/delete/{idMonan}", method = RequestMethod.GET)
    public String xoaMonAn(Model model, @PathVariable("idMonan") int idMonan) {
    	foodService.delete(idMonan);
        return "redirect:/quanly/monan";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.GET)
    public String getThemMonan(Model model) {
    	model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    	model.addAttribute("mon", new Mon());
        return "quanly-them-mon-an";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.POST)
    public String postThemMonan(@RequestParam("hinhanh") MultipartFile file,@RequestParam String hinhanh_backup , @ModelAttribute("mon")   Mon mon, BindingResult result, Model model) {
    	if(!file.isEmpty()){
    		try{
    		byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String uploadPath = context.getRealPath("") + File.separator
					+ UPLOAD_DIRECTORY;
			File dir = new File(uploadPath);

			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			System.out.println("Server File Location="
					+ serverFile.getAbsolutePath());
			String filepath = "/" + UPLOAD_DIRECTORY + "/"
					+ file.getOriginalFilename();
			mon.setHinhAnh(file.getOriginalFilename());
    		}catch(Exception e){
    			
    		}
    	}
    	System.out.println(hinhanh_backup + "--" + mon.getHinhAnh());
    	if((hinhanh_backup != "" || hinhanh_backup != null) && mon.getHinhAnh() == null){
    		mon.setHinhAnh(hinhanh_backup);
    	}
    	monValidator.validate(mon, result);
    	if(result.hasErrors()){
    		model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    		return "quanly-them-mon-an";
    	}
    	mon.setActive(true);
    	mon.setSoLuongDaBan(0);
    	foodService.save(mon);
        return "redirect:/quanly/monan/themmonan";
    }

    @RequestMapping(value = "/monan/them-mon-an-vao-danh-muc", method = RequestMethod.GET)
    public String getThemMonanVaoDanhmuc(Model model) {
        return "quanly-them-mon-an-vao-danh-muc";
    }
    
    @RequestMapping(value = "/monan/active/{idMonan}", method = RequestMethod.GET)
    public String activeMonAn(Model model, @PathVariable("idMonan") int idMonan) {
    	foodService.active(idMonan);
    	//cần phải active lại danh mục đó
        return "redirect:/quanly/monan?type=deleted";
    }
}
