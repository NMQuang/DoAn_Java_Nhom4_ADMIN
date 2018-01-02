package foodGroup4Quanly.controller.chinhanh;

import foodGroup4Quanly.common.Utils;
import foodGroup4Quanly.entity.Chiphingay;
import foodGroup4Quanly.service.ChiPhiNgayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/chinhanh/chiphi")
public class ChiNhanhChiPhiController {

    private static final String formatDate = "dd-MM-yyyy";

    @Autowired
    ChiPhiNgayService chiPhiNgayService;

    @RequestMapping(value = "/ngay")
    public String getChiPhiNgay(Model model, @RequestParam(value = "date", required = false) String strDate) {
        Date date = convertStringToDate(strDate);
        List<Chiphingay> listChiPhiNgay = chiPhiNgayService.getChiPhiNgayInDate(date);
        model.addAttribute("listChiPhiNgay", listChiPhiNgay);
        return "chinhanh-chi-phi-ngay";
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

    @RequestMapping(value = "/thang")
    public String getChiPhiThang() {
        return "chinhanh-chi-phi-thang";
    }

    @RequestMapping(value = "luongnhanvien")
    public String getChiLuongNhanVien() {
        return "chinhanh-luong-nhan-vien";
    }

}
