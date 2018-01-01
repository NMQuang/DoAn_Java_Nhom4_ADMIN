package foodGroup4Quanly.controller.chinhanh;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import foodGroup4Quanly.common.AccountAdminUserDetails;
import foodGroup4Quanly.entity.Chinhanh;


@ControllerAdvice("foodGroup4Quanly.controller.chinhanh")
public class GlobalAdviceController {
	
	@ModelAttribute("chinhanh")
	public Chinhanh getChiNhanh(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof AccountAdminUserDetails){
			Chinhanh cn = ((AccountAdminUserDetails)principal).getAccountAdmin().getChinhanh();
			return cn;
		}
		return null;
	}
}
