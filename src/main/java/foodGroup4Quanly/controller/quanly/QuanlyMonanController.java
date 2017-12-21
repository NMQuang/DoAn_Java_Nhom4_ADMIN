package foodGroup4Quanly.controller.quanly;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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
import foodGroup4Quanly.entity.Mon;
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
	
    @RequestMapping(value = "/monan", method = RequestMethod.GET)
    public String getListMonan(Model model) {
        return "quanly-list-mon-an";
    }

    @RequestMapping(value = "/monan/{idMonan}", method = RequestMethod.GET)
    public String getChitietMonan(Model model, @PathVariable("idMonan") int idMonan) {
        return "quanly-chi-tiet-mon-an";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.GET)
    public String getThemMonan(Model model) {
    	model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
    	model.addAttribute("mon", new Mon());
        return "quanly-them-mon-an";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.POST)
    public String postThemMonan(@RequestParam("hinhanh") MultipartFile file, @ModelAttribute("mon") @Valid  Mon mon, BindingResult result, Model model) {
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
}
