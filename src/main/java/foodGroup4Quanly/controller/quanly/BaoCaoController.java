package foodGroup4Quanly.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/quanly/baocao")
public class BaoCaoController {
	
	@RequestMapping("/tongdoanhthu")
	public String getTongDanhThuPage(){
		return "quanly-tong-danh-thu";
	}
}
