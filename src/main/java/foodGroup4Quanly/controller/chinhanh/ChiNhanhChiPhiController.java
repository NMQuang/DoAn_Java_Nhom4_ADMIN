package foodGroup4Quanly.controller.chinhanh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chinhanh/chiphi")
public class ChiNhanhChiPhiController {

    @RequestMapping(value = "/ngay")
    public String getChiPhiNgay() {
        return "chinhanh-chi-phi-ngay";
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
