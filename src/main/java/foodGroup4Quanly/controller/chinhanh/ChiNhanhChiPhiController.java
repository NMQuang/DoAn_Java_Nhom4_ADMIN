package foodGroup4Quanly.controller.chinhanh;

import foodGroup4Quanly.common.ChiPhiNgayValidator;
import foodGroup4Quanly.common.TienThueNhaValidator;
import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.dto.ChiPhiNgayDto;
import foodGroup4Quanly.dto.TienThueNhaDto;
import foodGroup4Quanly.entity.Chiphingay;
import foodGroup4Quanly.entity.Tienthuenha;
import foodGroup4Quanly.service.ChiPhiNgayService;
import foodGroup4Quanly.service.TienThueNhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/chinhanh/chiphi")
public class ChiNhanhChiPhiController {

    @Autowired
    ChiPhiNgayValidator chiPhiNgayValidator;

    @Autowired
    ChiPhiNgayService chiPhiNgayService;

    @Autowired
    TienThueNhaService tienThueNhaService;

    @Autowired
    TienThueNhaValidator tienThueNhaValidator;

    @RequestMapping(value = "/ngay", method = RequestMethod.GET)
    public String getChiPhiNgay(Model model, @RequestParam(value = "date", required = false) String strDate) {
        Calendar calDate = convertStringToDate(strDate, "dd-MM-yyyy");
        List<Chiphingay> listChiPhiNgay = chiPhiNgayService.getChiPhiNgayInDate(calDate.getTime());
        model.addAttribute("listChiPhiNgay", listChiPhiNgay);
        return "chinhanh-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/create", method = RequestMethod.GET)
    public String getThemChiPhiNgay(Model model) {
        model.addAttribute("chiPhiNgay", new ChiPhiNgayDto());
        return "chinhanh-them-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/create", method = RequestMethod.POST)
    public String postThemChiPhiNgay(Model model,
                                     @ModelAttribute("chiPhiNgay") ChiPhiNgayDto chiPhiNgayDto,
                                     BindingResult bindingResult) {
        chiPhiNgayValidator.validate(chiPhiNgayDto, bindingResult);
        if(bindingResult.hasErrors()) {
            return "chinhanh-them-chi-phi-ngay";
        }
        Chiphingay chiphingay = chiPhiNgayDto.getChiPhiNgay();
        chiPhiNgayService.create(chiphingay);
        return "redirect:/chinhanh/chiphi/ngay/create";
    }

    @RequestMapping(value = "/ngay/update/{id}", method = RequestMethod.GET)
    public String getUpdateChiPhiNgay(Model model,
                                      @PathVariable("id")int id) {
        ChiPhiNgayDto chiPhiNgayDto = new ChiPhiNgayDto(chiPhiNgayService.getById(id));
        model.addAttribute("chiPhiNgay", chiPhiNgayDto);
        model.addAttribute("id", id);
        model.addAttribute("type", "update");
        return "chinhanh-them-chi-phi-ngay";
    }

    @RequestMapping(value = "/ngay/update", method = RequestMethod.POST)
    public String postUpdateChiPhiNgay(Model model,
                                       @RequestParam("id") int id,
                                       @ModelAttribute("chiPhiNgay") ChiPhiNgayDto chiPhiNgayDto,
                                       BindingResult bindingResult) {
        chiPhiNgayValidator.validate(chiPhiNgayDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute("id", id);
            model.addAttribute("type", "update");
            return "chinhanh-them-chi-phi-ngay";
        }
        Chiphingay chiphingay = chiPhiNgayService.getById(id);
        chiphingay = chiPhiNgayDto.tranferChiPhiNgay(chiphingay);
        chiPhiNgayService.update(chiphingay);

        return "redirect:/chinhanh/chiphi/ngay/update/" + id;
    }

    @RequestMapping(value = "/ngay/delete", method = RequestMethod.POST)
    public String postDeleteChiPhiNgay(HttpServletRequest request, @RequestParam("id") int id) {
        chiPhiNgayService.deleteById(id);

        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/thang", method = RequestMethod.GET)
    public String getChiPhiThang(Model model, @RequestParam(value = "year", required = false) String strYear) {
        if(strYear == null) {
            strYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        }

        List<Tienthuenha> listTienThueNha = tienThueNhaService.getTienThueNhaOfYear(strYear);

        model.addAttribute("listTienThueNha", listTienThueNha);

        return "chinhanh-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/create", method = RequestMethod.GET)
    public String getCreateChiPhiThang(Model model) {
        model.addAttribute("tienThueNha", new TienThueNhaDto());
        return "chinhanh-them-chi-phi-thang";
    }

    @RequestMapping(value = "/thang/create", method = RequestMethod.POST)
    public String postCreateChiPhiThang(Model model,
                                        @ModelAttribute("tienThueNha")TienThueNhaDto tienThueNhaDto,
                                        BindingResult bindingResult) {
        tienThueNhaValidator.validate(tienThueNhaDto, bindingResult);
        if(bindingResult.hasErrors()) {
            return "chinhanh-them-chi-phi-thang";
        }
        Tienthuenha tienthuenha = tienThueNhaDto.getTienThueNha();
        tienThueNhaService.create(tienthuenha);

        model.addAttribute("tienThueNha", new TienThueNhaDto());
        return "chinhanh-them-chi-phi-thang";
    }

    @RequestMapping(value = "luongnhanvien")
    public String getChiLuongNhanVien() {
        return "chinhanh-luong-nhan-vien";
    }

    private Calendar convertStringToDate(String strDate, String formatDate) {
        Calendar cal = Calendar.getInstance();
        if(strDate != null) {
            Date date = Utils.parseDate(strDate, formatDate);
            if(date != null) {
                cal.setTime(date);
            }
        }

        return cal;
    }
}
