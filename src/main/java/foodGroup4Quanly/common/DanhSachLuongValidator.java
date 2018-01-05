package foodGroup4Quanly.common;

import foodGroup4Quanly.dto.DanhSachLuongNhanVienDto;
import foodGroup4Quanly.dto.LuongNhanVienDto;
import foodGroup4Quanly.entity.Nhanvien;
import foodGroup4Quanly.service.LuongNhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.Date;

@Component
public class DanhSachLuongValidator implements Validator {

    @Autowired
    LuongNhanVienService luongNhanVienService;

    @Override
    public boolean supports(Class<?> aClass) {
        return DanhSachLuongNhanVienDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            DanhSachLuongNhanVienDto dsLuongNhanVien =
                    (DanhSachLuongNhanVienDto) o;

            if(!dsLuongNhanVien.getUpdate()) {
                Date date = Utils.parseDate(dsLuongNhanVien.getThoiGian(), "MM-yyyy");
                if (date == null) {
                    errors.rejectValue("thoiGian", "luongnhanvien.thoiGian.invalid");
                } else {
                    Calendar cal = Utils.convertDateToCalendar(date);
                    String strMonth = String.format("%02d", cal.get(Calendar.MONTH) + 1);
                    String strYear = String.format("%04d", cal.get(Calendar.YEAR));

                    Nhanvien nvBk = null;
                    if (Utils.getChinhanhHienTai().getNhanviens() != null) {
                        nvBk = Utils.getChinhanhHienTai().getNhanviens().iterator().next();
                    }
                    if (nvBk != null) {
                        if (luongNhanVienService.hasLuongNhanVien(nvBk.getNhanVienId(), strMonth, strYear)) {
                            errors.rejectValue("thoiGian", "luongnhanvien.thoiGian.dumplicate");
                        }
                    }
                }
            }

            // Kiem tra tung nhan vien
            for(int i = 0; i < dsLuongNhanVien.getListLuongNhanVien().size(); i++) {
                LuongNhanVienDto luongNv = dsLuongNhanVien.getListLuongNhanVien().get(i);
                if(luongNv.getLuong() == null) {
                    errors.rejectValue("listLuongNhanVien["+i+"].luong", "luongnhanvien.luong.invalid");
                }
                if(luongNv.getMota() == null || (luongNv.getMota().length() < 3 || luongNv.getMota().length() > 255)) {
                    errors.rejectValue("listLuongNhanVien["+i+"].mota", "luongnhanvien.mota.invalid");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
