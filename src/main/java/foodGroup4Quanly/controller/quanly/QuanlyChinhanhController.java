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

import foodGroup4Quanly.common.ChiNhanhValidator;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.service.BranchService;
import foodGroup4Quanly.service.ChiNhanhMonService;
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

	@Autowired
	public ChiNhanhValidator chiNhanhValidator;

	@Autowired
	public ChiNhanhMonService chiNhanhMonService;

	/***
	 * get danh sách tất cả các chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh", method = RequestMethod.GET)
	public String getListChinhanh(Model model) {
		model.addAttribute("listChiNhanh", branchService.getListChiNhanh());
		return "quanly-list-chi-nhanh";
	}

	/***
	 * get thông tin chi tiết của 1 chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		if (idChinhanh < 0 || idChinhanh > 100) {
			return "quanly-list-chi-nhanh";
		} else {
			Chinhanh chiNhanh = branchService.getInfoChiNhanh(idChinhanh);
			model.addAttribute("chiNhanh",chiNhanh);
			model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
		}
		return "quanly-chi-tiet-chi-nhanh";
	}

	/***
	 * update 1 chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.POST)
	    public String updateChitietMonan(Model model, @PathVariable("idChinhanh") int idChiNhanh, @RequestParam("hinhanh") MultipartFile file, @ModelAttribute("chiNhanh") Chinhanh chiNhanh, BindingResult result) {
	    	Chinhanh cn = branchService.getInfoChiNhanh(idChiNhanh);
	    	if(!file.isEmpty()){
	    		try{
	    		byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String uploadPath = context.getRealPath("") + File.separator
						+ UPLOAD_DIRECTORY;
				File dir = new File(uploadPath);

				if (!dir.exists()) {
					dir.mkdirs();
				}
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
				cn.setHinhAnh(file.getOriginalFilename());
	    		}catch(Exception e){

	    		}
	    	}
	    	chiNhanh.setHinhAnh(cn.getHinhAnh());
	    	chiNhanhValidator.validate(chiNhanh, result);
	    	if(result.hasErrors()){
	    		model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
	    		model.addAttribute("chiNhanh",chiNhanh);
	    		return "quanly-chi-tiet-chi-nhanh";
	    	}
	    	cn.setTen(chiNhanh.getTen());
	    	cn.setDiaChi(chiNhanh.getDiaChi());
	    	cn.setDienThoai(chiNhanh.getDienThoai());
	    	cn.setTinhthanh(chiNhanh.getTinhthanh());
	    	branchService.update(cn);

	    	model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
	    	model.addAttribute("chiNhanh", branchService.getInfoChiNhanh(idChiNhanh));
	        return "quanly-chi-tiet-chi-nhanh";
	    }

	/***
	 * thêm 1 chi nhánh
	 * */
	@RequestMapping(value = "chinhanh/themchinhanh", method = RequestMethod.GET)
	public String getThemChinhanh(Model model) {
		model.addAttribute("chiNhanh", new Chinhanh());
		model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
		return "quanly-them-chi-nhanh";
	}

	/***
	 * thêm 1 chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh/themchinhanh", method = RequestMethod.POST)
	public String postThemChinhanh(@RequestParam("hinhanh") MultipartFile file, @RequestParam String hinhanh_backup, @ModelAttribute("chiNhanh") @Valid  Chinhanh chiNhanh, BindingResult result, Model model) {
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

		System.out.println(hinhanh_backup + "--" + chiNhanh.getHinhAnh());
	    	if((hinhanh_backup != "" || hinhanh_backup != null) && chiNhanh.getHinhAnh() == null){
	    		chiNhanh.setHinhAnh(hinhanh_backup);
	    	}

	    	chiNhanhValidator.validate(chiNhanh, result);
	    	if(result.hasErrors()){
	    		model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
	    		return "quanly-them-chi-nhanh";
	    	}
	    	branchService.saveChiNhanh(chiNhanh);
		return "redirect:/quanly/chinhanh";
	}

	/***
	 * get thông tin chi tiết bàn của 1 chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietBanChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {
		return "quanly-chi-tiet-chi-nhanh-ban";
	}

	/***
	 * get thông tin chi tiết bàn của 1 chi nhánh
	 * */
	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietMenuChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		model.addAttribute("menu", chiNhanhMonService.getListChiNhanhMonByChiNhanh(idChinhanh));
		model.addAttribute("branch", branchService.getInfoChiNhanh(idChinhanh));
		return "quanly-chi-tiet-chi-nhanh-menu";
	}
}
