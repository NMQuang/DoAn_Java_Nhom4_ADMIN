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

import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.service.BranchService;
import foodGroup4Quanly.service.TinhThanhService;

@Controller
@RequestMapping("/quanly")
public class QuanlyChinhanhController {

	final String UPLOAD_DIRECTORY = "resources/images/chi-nhanh";
	@Autowired
	public ServletContext context;

	@Autowired
	public BranchService branchService;

	@Autowired
	public TinhThanhService tinhThanhService;

	@RequestMapping(value = "/chinhanh", method = RequestMethod.GET)
	public String getListChinhanh(Model model) {
		model.addAttribute("listChiNhanh", branchService.getListChiNhanh());
		return "quanly-list-chi-nhanh";
	}

	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		if (idChinhanh < 0 || idChinhanh > 100) {
			return "quanly-list-chi-nhanh";
		} else {
			Chinhanh chiNhanh = branchService.getInfoChiNhanh(idChinhanh);
			model.addAttribute("branch",chiNhanh);
		}
		return "quanly-chi-tiet-chi-nhanh";
	}

	@RequestMapping(value = "chinhanh/themchinhanh", method = RequestMethod.GET)
	public String getThemChinhanh(Model model) {
		model.addAttribute("chiNhanh", new Chinhanh());
		model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
		return "quanly-them-chi-nhanh";
	}

	@RequestMapping(value = "/chinhanh/themchinhanh", method = RequestMethod.POST)
	public String postThemChinhanh(@RequestParam("hinhanh") MultipartFile file, @ModelAttribute("chiNhanh") @Valid  Chinhanh chiNhanh, BindingResult result, Model mode) {
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
				chiNhanh.setHinhAnh(file.getOriginalFilename());
	    		}catch(Exception e){

	    		}
	    	}
		return "quanly-list-chi-nhanh";
	}
}
