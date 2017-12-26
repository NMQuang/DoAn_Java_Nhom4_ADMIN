package foodGroup4Quanly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MutualController {
	@RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLoginPage(){
    	return "login-page";
    }
}
