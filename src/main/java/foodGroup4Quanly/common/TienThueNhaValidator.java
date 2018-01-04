package foodGroup4Quanly.common;

import foodGroup4Quanly.dao.TienThueNhaDao;
import foodGroup4Quanly.dto.TienThueNhaDto;
import foodGroup4Quanly.entity.Tienthuenha;
import foodGroup4Quanly.entity.TienthuenhaPK;
import foodGroup4Quanly.service.TienThueNhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.Date;

@Component
public class TienThueNhaValidator implements Validator {

    @Autowired
    TienThueNhaService tienThueNhaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return TienThueNhaDao.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            TienThueNhaDto tienThueNhaDto = (TienThueNhaDto) o;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"thoiGian", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ten", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mota", "NotEmpty");

            if(!tienThueNhaDto.getUpdate()) {

                Date date = Utils.parseDate(tienThueNhaDto.getThoiGian(), "MM-yyyy");
                if (date == null) {
                    errors.rejectValue("thoiGian", "chiphithang.thoiGian.invalid");
                } else {
                    Calendar cal = Utils.convertDateToCalendar(date);
                    String strMonth = String.format("%02d", cal.get(Calendar.MONTH) + 1);
                    String strYear = String.format("%04d", cal.get(Calendar.YEAR));

                    System.out.println("strMOnth:" + strMonth + "\n" + "strYear:" + strYear);
                    Tienthuenha tienthuenha = tienThueNhaService.getById(new TienthuenhaPK(strMonth, strYear));
                    if (tienthuenha != null) {
                        System.out.println(tienthuenha.getThang() + " " + tienthuenha.getNam());
                        errors.rejectValue("thoiGian", "chiphithang.thoiGian.dumplicate");
                    }
                }
            }

            if(tienThueNhaDto.getTen() != null) {
                if(tienThueNhaDto.getTen().length() < 3 || tienThueNhaDto.getTen().length() > 255) {
                    errors.rejectValue("ten", "chiphithang.ten.invalid");
                }
            }

            if(tienThueNhaDto.getMota() != null) {
                if(tienThueNhaDto.getMota().length() < 3 || tienThueNhaDto.getMota().length() > 255) {
                    errors.rejectValue("mota", "chiphithang.mota.invalid");
                }
            }

            if(tienThueNhaDto.getTien() == null || tienThueNhaDto.getTien() <= 0) {
                errors.rejectValue("tien", "chiphithang.tien.invalid");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
