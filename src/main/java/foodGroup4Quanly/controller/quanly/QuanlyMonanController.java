package foodGroup4Quanly.controller.quanly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/quanly")
public class QuanlyMonanController {

    @RequestMapping(value = "/monan", method = RequestMethod.GET)
    public String getListMonan(Model model) {
        return "quanly-list-mon-an";
    }

    @RequestMapping(value = "/monan/{idMonan}", method = RequestMethod.GET)
    public String getChitietMonan(Model model, @PathVariable("idMonan") int idMonan) {
        return "quanly-chi-tiet-mon-an";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.GET)
    public String getThemMonan(Model model) {
        return "quanly-them-mon-an";
    }

    @RequestMapping(value = "/monan/themmonan", method = RequestMethod.POST)
    public String postThemMonan(Model model) {
        return "quanly-list-mon-an";
    }

    @RequestMapping(value = "/monan/them-mon-an-vao-danh-muc", method = RequestMethod.GET)
    public String getThemMonanVaoDanhmuc(Model model) {
        return "quanly-them-mon-an-vao-danh-muc";
    }
}
