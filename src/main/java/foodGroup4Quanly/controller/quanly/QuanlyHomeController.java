package foodGroup4Quanly.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quanly")
public class QuanlyHomeController {

    @RequestMapping(value =  "", method = RequestMethod.GET)
    public String getIndex(Model model) {
        return "quanly-index";
    }
}
