package foodGroup4Quanly.controller.chinhanh;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chinhanh")
public class ChiNhanhDonHangController {

    @RequestMapping(value = "/danhsachdonhang")
    public String getDanhSachDonHang(Model model) {
        return "chinhanh-danh-sach-don-hang";
    }

    @RequestMapping(value = "/chitietdonhang")
    public String getChiTietDonHang(Model model) {
        return "chinhanh-chi-tiet-don-hang";
    }
}
