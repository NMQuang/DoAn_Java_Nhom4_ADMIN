package foodGroup4Quanly.controller.quanly;

import foodGroup4Quanly.common.SuaDanhmucValidator;
import foodGroup4Quanly.common.ThemDanhmucValidator;
import foodGroup4Quanly.dto.SuaDanhMucDto;
import foodGroup4Quanly.dto.ThemDanhMucDto;
import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/quanly")
public class QuanlyDanhmucController {

    @Autowired
    DanhMucService danhMucService;

    @Autowired
    ThemDanhmucValidator themDanhmucValidator;

    @Autowired
    SuaDanhmucValidator suaDanhmucValidator;

    @RequestMapping(value = "/danhmuc", method = RequestMethod.GET)
    public String getListDanhmuc(Model model, @RequestParam(value = "type", required = false) String type) {

        type = normalizeType(type);
        List<Danhmuc> listDanhmuc;
        if(type.equals("deleted")) {
            listDanhmuc = danhMucService.getAllDanhMuc(false);
        } else {
            listDanhmuc = danhMucService.getAllDanhMuc(true);
        }

        model.addAttribute("type", type);
        model.addAttribute("listDanhmuc", listDanhmuc);
        model.addAttribute("themDm", new ThemDanhMucDto());
        model.addAttribute("suaDm", new SuaDanhMucDto());

        return "quanly-list-danh-muc";
    }

    @RequestMapping(value = "/danhmuc/{idDanhmuc}", method = RequestMethod.GET)
    public String getChitietDanhmuc(Model model,
                                    @PathVariable("idDanhmuc") int idDanhmuc,
                                    @RequestParam(value = "type", required = false) String type) {
        type = normalizeType(type);

        List<Mon> listMonByType;
        if(type.equals("deleted")) {
            listMonByType = danhMucService.getMonDeactiveByIdDm(idDanhmuc);
        } else {
            listMonByType = danhMucService.getMonActiveByIdDm(idDanhmuc);
        }
        model.addAttribute("type", type);
        model.addAttribute("listMonByType", listMonByType);

        return "quanly-chi-tiet-danh-muc";
    }

    @RequestMapping(value = "/danhmuc/create", method = RequestMethod.POST)
    public String postThemDanhmuc(Model model,
                                  @ModelAttribute(value = "themDm") ThemDanhMucDto themDm,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        themDanhmucValidator.validate(themDm, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("suaDm", new SuaDanhMucDto());
            model.addAttribute("listDanhmuc", danhMucService.getAllDanhmucDontcareActive());
            model.addAttribute("hasErrorCreateDm", true);
            return "quanly-list-danh-muc";
        }
        Danhmuc danhmuc = new Danhmuc();
        danhmuc.setTen(themDm.getTen());
        danhmuc.setActive(true);
        danhMucService.create(danhmuc);
        redirectAttributes.addFlashAttribute("createDmSuccess", true);

        return "redirect:/quanly/danhmuc/";
    }

    @RequestMapping(value = "/danhmuc/delete/{idDanhmuc}", method = RequestMethod.GET)
    public String getDeleteDanhmuc(Model model,
                                   @PathVariable("idDanhmuc") int idDanhmuc,
                                   RedirectAttributes redirectAttributes) {
        danhMucService.deactiveDanhmuc(idDanhmuc);

        redirectAttributes.addFlashAttribute("deleteDmSuccess", true);
        return "redirect:/quanly/danhmuc";
    }

    @RequestMapping(value = "/danhmuc/update", method = RequestMethod.POST)
    public String postUpdateDanhmuc(Model model,
                                   @ModelAttribute(value = "suaDm") SuaDanhMucDto suaDm,
                                   BindingResult result,
                                   RedirectAttributes redirectAttributes) {

        suaDanhmucValidator.validate(suaDm, result);
        if(result.hasErrors()) {
            model.addAttribute("themDm", new ThemDanhMucDto());
            model.addAttribute("listDanhmuc", danhMucService.getAllDanhmucDontcareActive());
            model.addAttribute("hasErrorUpdateDm", true);
            return "quanly-list-danh-muc";
        }
        danhMucService.doiTenDm(suaDm.getNewten(), suaDm.getIdDm());
        redirectAttributes.addFlashAttribute("updateDmSuccess", true);
        return "redirect:/quanly/danhmuc";
    }

    @RequestMapping(value = "/danhmuc/active/{idDanhmuc}", method = RequestMethod.GET)
    public String getActiveDanhmuc(Model model,
                                   @PathVariable("idDanhmuc") int idDanhmuc,
                                   RedirectAttributes redirectAttributes) {
        danhMucService.activeDanhmuc(idDanhmuc);

        redirectAttributes.addFlashAttribute("activeDmSuccess", true);
        return "redirect:/quanly/danhmuc";
    }

    private String normalizeType(String rawType) {
        String normalizeType = "";
        if(rawType == null) {
            normalizeType = "current";
        } else {
            normalizeType = rawType.equalsIgnoreCase("deleted") ? "deleted" : "current";
        }
        return normalizeType;
    }
}
