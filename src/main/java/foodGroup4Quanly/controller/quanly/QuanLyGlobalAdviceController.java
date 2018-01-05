package foodGroup4Quanly.controller.quanly;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import foodGroup4Quanly.common.AccountAdminUserDetails;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Nhanvien;


@ControllerAdvice("foodGroup4Quanly.controller.quanly")
public class QuanLyGlobalAdviceController {
	
	
	@ModelAttribute("nv_quanly")
	public Nhanvien getNhanVien(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof AccountAdminUserDetails){
			Nhanvien nv = ((AccountAdminUserDetails)principal).getAccountAdmin().getNhanvien();
			return nv;
		}
		return null;
	}
}
