package foodGroup4Quanly.controller.quanly;

import foodGroup4Quanly.common.DanhmucValidator;
import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quanly")
public class QuanlyDanhmucController {

    @Autowired
    DanhMucService danhMucService;

    @Autowired
    DanhmucValidator danhmucValidator;

    @RequestMapping(value = "/danhmuc", method = RequestMethod.GET)
    public String getListDanhmuc(Model model) {
        model.addAttribute("listDanhmuc", danhMucService.getAllDanhMuc());
        model.addAttribute("newDm", new Danhmuc());
        return "quanly-list-danh-muc";
    }

    @RequestMapping(value = "/danhmuc/{idDanhmuc}", method = RequestMethod.GET)
    public String getChitietDanhmuc(Model model, @PathVariable("idDanhmuc") int idDanhmuc) {
        return "quanly-chi-tiet-danh-muc";
    }

    @RequestMapping(value = "/danhmuc", method = RequestMethod.POST)
    public String postThemDanhmuc(Model model,
                                  @ModelAttribute(value = "newDm") Danhmuc newDm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        danhmucValidator.validate(newDm, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("listDanhmuc", danhMucService.getAllDanhMuc());
            model.addAttribute("hasErrorCreateDm", true);
            return "quanly-list-danh-muc";
        }
        newDm.setActive(true);
        danhMucService.create(newDm);
        redirectAttributes.addFlashAttribute("createDmSuccess", true);

        return "redirect:/quanly/danhmuc/";
    }
}
