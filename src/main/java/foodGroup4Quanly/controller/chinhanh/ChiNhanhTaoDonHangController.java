package foodGroup4Quanly.controller.chinhanh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chinhanh/taodonhang")
public class ChiNhanhTaoDonHangController {

    @RequestMapping(value = "/taiquan")
    public String getTaoDonHangTaiQuan(Model model) {
        return "chinhanh-tao-don-hang-tai-quan";
    }

    @RequestMapping(value = "/mangve")
    public String getTaoDonHangMangVe(Model model) {
        return "chinhanh-tao-don-hang-mang-ve";
    }

}
