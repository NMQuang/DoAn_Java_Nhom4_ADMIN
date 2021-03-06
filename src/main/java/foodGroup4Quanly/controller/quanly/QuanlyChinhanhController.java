package foodGroup4Quanly.controller.quanly;

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

import foodGroup4Quanly.common.BanValidator;
import foodGroup4Quanly.common.ChiNhanhValidator;
import foodGroup4Quanly.common.MonValidator;
import foodGroup4Quanly.common.PriceValidator;
import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.dto.BanDto;
import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Chinhanhmon;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.service.BanService;
import foodGroup4Quanly.service.BranchService;
import foodGroup4Quanly.service.ChiNhanhMonService;
import foodGroup4Quanly.service.DanhMucService;
import foodGroup4Quanly.service.FoodService;
import foodGroup4Quanly.service.TinhThanhService;

@Controller
@RequestMapping("/quanly")
public class QuanlyChinhanhController {

	final String UPLOAD_DIRECTORY = "C:/resources/images/chi-nhanh";
	final String UPLOAD_DIRECTORY1 = "C:/resources/images/mon-an";
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

	@Autowired
	public DanhMucService danhMucService;

	@Autowired
	public MonValidator monValidator;

	@Autowired
	public FoodService foodService;

	@Autowired
	public BanService banService;

	@Autowired
	public BanValidator banValidator;

	@Autowired
	public PriceValidator priceValidator;

	/***
	 * get danh sách tất cả các chi nhánh
	 */
	@RequestMapping(value = "/chinhanh", method = RequestMethod.GET)
	public String getListChinhanh(Model model, @RequestParam(required=false) String type, @RequestParam(required= false) Integer index) {

		int begin;
		int id = 1;
		if (index == null || index < 1) {
			begin = 0;
		} else {
			id = index;
			begin = 10 * (id - 1);
		}
		int count = branchService.countBranch();
    		int pages = count / 10 + (count %10 == 0 ? 0 : 1);
		model.addAttribute("listChiNhanh", branchService.getList(10, begin));
		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("type", type);
		return "quanly-list-chi-nhanh";
	}

	/***
	 * get thông tin đầy đủ của 1 chi nhánh
	 */
	@RequestMapping(value = "/chinhanh-daydu/{idChinhanh}", method = RequestMethod.GET)
	public String getThongTinChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		if (idChinhanh < 0 || idChinhanh > 100) {
			return "quanly-list-chi-nhanh";
		} else {
			Chinhanh chiNhanh = branchService.getInfoChiNhanh(idChinhanh);
			model.addAttribute("chiNhanh", chiNhanh);
			model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
			model.addAttribute("menu", chiNhanhMonService.getListChiNhanhMonByChiNhanh(idChinhanh));
			model.addAttribute("branch", branchService.getInfoChiNhanh(idChinhanh));
			model.addAttribute("table", banService.getListTableByChiNhanh(idChinhanh));
		}
		return "quanly-thong-tin-day-du-chi-nhanh";
	}

	/***
	 * get thông tin chi tiết của 1 chi nhánh
	 */
	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		if (idChinhanh < 0 || idChinhanh > 100) {
			return "quanly-list-chi-nhanh";
		} else {
			Chinhanh chiNhanh = branchService.getInfoChiNhanh(idChinhanh);
			model.addAttribute("chiNhanh", chiNhanh);
			model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
		}
		return "quanly-chi-tiet-chi-nhanh";
	}

	/***
	 * update 1 chi nhánh
	 */
	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.POST)
	public String updateChiNhanh(Model model, @PathVariable("idChinhanh") int idChiNhanh, @RequestParam("hinhanh") MultipartFile file, @ModelAttribute("chiNhanh") Chinhanh chiNhanh, BindingResult result) {
		Chinhanh cn = branchService.getInfoChiNhanh(idChiNhanh);
		if (!file.isEmpty()) {
			Utils.saveImage(file, context, UPLOAD_DIRECTORY);
			cn.setHinhAnh(file.getOriginalFilename());
		}
		chiNhanh.setHinhAnh(cn.getHinhAnh());
		chiNhanhValidator.validate(chiNhanh, result);
		if (result.hasErrors()) {
			model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
			model.addAttribute("chiNhanh", chiNhanh);
			return "quanly-chi-tiet-chi-nhanh";
		}
		cn.setTen(chiNhanh.getTen());
		cn.setDiaChi(chiNhanh.getDiaChi());
		cn.setDienThoai(chiNhanh.getDienThoai());
		cn.setTinhthanh(chiNhanh.getTinhthanh());
		branchService.update(cn);

		model.addAttribute("tinhThanh", tinhThanhService.getAllTinhThanh());
		model.addAttribute("chiNhanh", branchService.getInfoChiNhanh(idChiNhanh));
		return "redirect:/quanly/chinhanh";
	}

	/***
	 * thêm 1 chi nhánh
	 */
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
			Utils.saveImage(file, context, UPLOAD_DIRECTORY);
			chiNhanh.setHinhAnh(file.getOriginalFilename());
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
	    	chiNhanh.setActive(true);
	    	branchService.saveChiNhanh(chiNhanh);
		return "redirect:/quanly/chinhanh";
	}

	/***
	 * get thông tin chi tiết món của 1 chi nhánh
	 */
	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietMenuChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh, @RequestParam(required=false) String type, @RequestParam(required= false) Integer index) {

		int begin;
		int id = 1;
		if (index == null || index < 1) {
			begin = 0;
		} else {
			id = index;
			begin = 10 * (id - 1);
		}
		int count = chiNhanhMonService.countMonByChiNhanh(idChinhanh);
    		int pages = count / 10 + (count %10 == 0 ? 0 : 1);
		model.addAttribute("index", id);
    		model.addAttribute("pages", pages);
    		model.addAttribute("type", type);
		model.addAttribute("menu", chiNhanhMonService.getListChiNhanhMonPageByChiNhanh(idChinhanh,10,begin));
		model.addAttribute("branch", branchService.getInfoChiNhanh(idChinhanh));
		return "quanly-chi-tiet-chi-nhanh-menu";
	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}/themmonan", method = RequestMethod.GET)
	public String getThemMonan(Model model, @PathVariable("idChinhanh") int idChinhanh) {
		model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
		model.addAttribute("mon", new Mon());

		return "quanly-them-mon-an";
	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}/themmonan", method = RequestMethod.POST)
	public String postThemMonan(@RequestParam("hinhanh") MultipartFile file, @RequestParam String hinhanh_backup, @ModelAttribute("mon") Mon mon, BindingResult result, Model model, @PathVariable("idChinhanh") int idChinhanh) {
		if (!file.isEmpty()) {
			Utils.saveImage(file, context, UPLOAD_DIRECTORY1);
			mon.setHinhAnh(file.getOriginalFilename());
		}
		System.out.println(hinhanh_backup + "--" + mon.getHinhAnh());
		if ((hinhanh_backup != "" || hinhanh_backup != null) && mon.getHinhAnh() == null) {
			mon.setHinhAnh(hinhanh_backup);
		}
		monValidator.validate(mon, result);
		if (result.hasErrors()) {
			model.addAttribute("ADanhmuc", danhMucService.getAllDanhMuc());
			return "redirect:/quanly/chinhanh-menu/"+idChinhanh + "/themmonan";
		}
		mon.setActive(true);
		mon.setSoLuongDaBan(0);
		foodService.save(mon);
		Chinhanhmon chiNhanhMon = new Chinhanhmon();
		chiNhanhMon.setMon(mon);
		chiNhanhMon.setChinhanh(branchService.getInfoChiNhanh(idChinhanh));
		chiNhanhMonService.save(chiNhanhMon);
		return "redirect:/quanly/chinhanh-menu/"+idChinhanh;
	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}/suamonan/{idMon}", method = RequestMethod.GET)
	public String suaMonan(Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idMon") int idMon) {
		List<Chinhanhmon> mons = chiNhanhMonService.getListChiNhanhMonByChiNhanh(idChinhanh);
		Chinhanhmon mon = new Chinhanhmon();

		for (Chinhanhmon monItem : mons) {
			if (idMon == monItem.getMon().getMonId()) {
				mon = monItem;
			}
		}

		model.addAttribute("mon", mon);
		return "quanly-sua-chi-nhanh-mon-an";
	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}/suamonan/{idMon}", method = RequestMethod.POST)
	public String suaMonan(@ModelAttribute("mon") Chinhanhmon mons, BindingResult result, Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idMon") int idMon) {

		priceValidator.validate(mons, result);
		if (result.hasErrors()) {
			return "redirect:/quanly/chinhanh-menu/"+idChinhanh+"/suamonan/"+idMon;
		}
		chiNhanhMonService.updateGia(idChinhanh, idMon, mons.getGia());
		return "redirect:/quanly/chinhanh-menu/"+idChinhanh;

	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}/xoamonan/{idMon}", method = RequestMethod.GET)
	public String xoaMonan(Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idMon") int idMon) {
//		foodService.delete(idMon);
		chiNhanhMonService.delete(idChinhanh, idMon);
		return "redirect:/quanly/chinhanh-menu/"+idChinhanh;
	}

	@RequestMapping(value = "/chinhanh-menu/{idChinhanh}", method = RequestMethod.POST)
	public String updateChitietMonan(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		return "redirect:/quanly/chinhanh/";
	}


	/***
	 * get thông tin chi tiết bàn của 1 chi nhánh
	 */
	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietBanChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {
		model.addAttribute("table", banService.getListTableByChiNhanh(idChinhanh));
		List<BanDto> list = banService.getListTableByChiNhanh(idChinhanh);
		model.addAttribute("branch", branchService.getInfoChiNhanh(idChinhanh));
		return "quanly-chi-tiet-chi-nhanh-ban";
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}/themban", method = RequestMethod.GET)
	public String getThemBan(Model model, @PathVariable("idChinhanh") int idChinhanh) {
		model.addAttribute("chinhanh", branchService.getInfoChiNhanh(idChinhanh));
		model.addAttribute("ban", new Ban());

		return "quanly-them-ban";
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}/themban", method = RequestMethod.POST)
	public String postThemBan(@ModelAttribute("ban") Ban ban, BindingResult result, Model model, @PathVariable("idChinhanh") int idChinhanh) {

		banValidator.validate(ban, result);
		if (result.hasErrors()) {
//			model.addAttribute("chinhanh", branchService.getListChiNhanh());
			return "redirect:/quanly/chinhanh-ban/"+idChinhanh + "/themban";
		}
		ban.setChinhanh(branchService.getInfoChiNhanh(idChinhanh));
		ban.setTinhTrang(0);
		ban.setActive(true);
		banService.saveBan(ban);
		return "redirect:/quanly/chinhanh-ban/"+idChinhanh;
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}/xoaban/{idBan}", method = RequestMethod.GET)
	public String xoaBan(Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idBan") int idBan) {
		banService.delete(idBan);
		return "redirect:/quanly/chinhanh-ban/"+idChinhanh;
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}/suaban/{idBan}", method = RequestMethod.GET)
	public String getChiTietBan(Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idBan") int idBan, @ModelAttribute("ban") Ban ban) {
		model.addAttribute("ban", banService.getInfoBan(idBan));
		model.addAttribute("chinhanh", branchService.getInfoChiNhanh(idChinhanh));
		return "quanly-chi-tiet-ban";
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}/suaban/{idBan}", method = RequestMethod.POST)
	public String updateBan(Model model, @PathVariable("idChinhanh") int idChinhanh, @PathVariable("idBan") int idBan, @ModelAttribute("ban") Ban ban, BindingResult result) {
		Ban b = banService.getInfoBan(idBan);

		if (result.hasErrors()) {
			return "quanly-chi-tiet-ban";
		}

//		b.setChinhanh(ban.getChinhanh());
		b.setTenBan(ban.getTenBan());
		b.setTinhTrang(ban.getTinhTrang());
//		Chinhanh cn = branchService.getInfoChiNhanh(idChinhanh);
//		for (Ban bt : cn.getBans()) {
//			if (bt.getBanId() == idBan) {
				banService.update(b);
//			}
//		}

		return "redirect:/quanly/chinhanh-ban/"+idChinhanh;
	}

	@RequestMapping(value = "/chinhanh-ban/{idChinhanh}", method = RequestMethod.POST)
	public String updateChitietBan(Model model, @PathVariable("idChinhanh") int idChinhanh) {
		return "redirect:/quanly/chinhanh/";
	}
}
