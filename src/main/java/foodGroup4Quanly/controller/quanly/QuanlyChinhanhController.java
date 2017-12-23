package foodGroup4Quanly.controller.quanly;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.service.BranchService;

@Controller
@RequestMapping("/quanly")
public class QuanlyChinhanhController {

	final String UPLOAD_DIRECTORY = "resources/images/mon-an";
	@Autowired
	ServletContext context;

	@Autowired
	BranchService branchService;

	@RequestMapping(value = "/chinhanh", method = RequestMethod.GET)
	public String getListChinhanh(Model model) {
		model.addAttribute("listChiNhanh", branchService.getListChiNhanh());
		return "list-chi-nhanh";
	}

	@RequestMapping(value = "/chinhanh/{idChinhanh}", method = RequestMethod.GET)
	public String getChitietChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {

		if (idChinhanh < 0 || idChinhanh > 100) {
			return "list-chi-nhanh";
		} else {
			Chinhanh chiNhanh = branchService.getInfoChiNhanh(idChinhanh);
			model.addAttribute("branch",chiNhanh);
		}
		return "chi-tiet-chi-nhanh";
	}

	@RequestMapping(value = "chinhanh/themchinhanh", method = RequestMethod.GET)
	public String getThemChinhanh(Model model) {
		return "quanly-them-chi-nhanh";
	}

	@RequestMapping(value = "/chinhanh/themchinhanh", method = RequestMethod.POST)
	public String postThemChinhanh(Model model) {
		return "quanly-list-chi-nhanh";
	}
}
