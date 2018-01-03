package foodGroup4Quanly.controller.chinhanh;

import foodGroup4Quanly.common.ChiPhiNgayValidator;
import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.dto.ChiPhiNgayDto;
import foodGroup4Quanly.entity.Chiphingay;
import foodGroup4Quanly.service.ChiPhiNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/chinhanh/chiphi")
public class ChiNhanhChiPhiController {

    private static final String formatDate = "dd-MM-yyyy";

    @Autowired
    ChiPhiNgayValidator chiPhiNgayValidator;

    @Autowired
    ChiPhiNgayService chiPhiNgayService;

    @RequestMapping(value = "/ngay", method = RequestMethod.GET)
    public String getChiPhiNgay(Model model, @RequestParam(value = "date", required = false) String strDate) {
        Date date = convertStringToDate(strDate);
        List<Chiphingay> listChiPhiNgay = chiPhiNgayService.getChiPhiNgayInDate(date);
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

    @RequestMapping(value = "/thang")
    public String getChiPhiThang() {
        return "chinhanh-chi-phi-thang";
    }

    @RequestMapping(value = "luongnhanvien")
    public String getChiLuongNhanVien() {
        return "chinhanh-luong-nhan-vien";
    }

    private Date convertStringToDate(String strDate) {
        Date date;
        if(strDate != null) {
            try {
                date = Utils.parseDate(strDate, formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
                date = Calendar.getInstance().getTime();
            }
        }  else {
            date = Calendar.getInstance().getTime();
        }
        return date;
    }
}
