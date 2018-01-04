package foodGroup4Quanly.controller.tongdai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tongdai")
public class TongDaiController {

    @RequestMapping(value = "/chi-tiet-don-hang", method = RequestMethod.GET)
    public String getChiTietDonHang(Model model) {
        return "tongdai-chi-tiet-don-hang";
    }

    @RequestMapping(value = "/danh-sach-don-hang", method = RequestMethod.GET)
    public String getDanhSachDonHang(Model model) {
        return "tongdai-danh-sach-don-hang";
    }

    @RequestMapping(value = "/tao-don-hang-dien-thoai")
    public String getDonHangDienThoai(Model model) {
        return "tongdai-tao-don-hang-dien-thoai";
    }

}
