package foodGroup4Quanly.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import foodGroup4Quanly.common.AccountAdminUserDetails;

@Controller
public class MutualController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String redirectUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof AccountAdminUserDetails){
			switch(((AccountAdminUserDetails)principal).getAccountAdmin().getQuyen()){
			case "QUANLY":
				return "redirect:/quanly";
			case "TONGDAI":
				return "redirect:/tongdai";
			case "CHINHANH":
				return "redirect:/chinhanh";
			}
			
		}
		return "redirect:/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLoginPage(){
    	return "login-page";
    }
}
