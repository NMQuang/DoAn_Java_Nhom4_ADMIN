package foodGroup4Quanly.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quanly")
public class QuanlyChinhanhController {

    @RequestMapping(value = "/chinhanh", method = RequestMethod.GET)
    public String getListChinhanh(Model model) {
        return "quanly-list-chi-nhanh";
    }

    @RequestMapping(value = "/chinhanh/{idChinhanh}",  method = RequestMethod.GET)
    public String getChitietChinhanh(Model model, @PathVariable("idChinhanh") int idChinhanh) {
        return "quanly-chi-tiet-chi-nhanh";
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
