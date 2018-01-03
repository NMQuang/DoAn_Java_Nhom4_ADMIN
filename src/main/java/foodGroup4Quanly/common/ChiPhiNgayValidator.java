package foodGroup4Quanly.common;

import foodGroup4Quanly.dto.ChiPhiNgayDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ChiPhiNgayValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ChiPhiNgayDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            ChiPhiNgayDto chiPhiNgayDto = (ChiPhiNgayDto) o;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mota", "NotEmpty");

            if(chiPhiNgayDto.getTen() != null) {
                if(chiPhiNgayDto.getTen().length() < 3 || chiPhiNgayDto.getTen().length() > 255) {
                    errors.rejectValue("ten", "chiphingay.ten.invalid");
                }
            }

            if(chiPhiNgayDto.getMota() != null) {
                if(chiPhiNgayDto.getMota().length() < 3 || chiPhiNgayDto.getMota().length() > 255) {
                    errors.rejectValue("mota", "chiphingay.mota.invalid");
                }
            }

            if(chiPhiNgayDto.getTien() == null || chiPhiNgayDto.getTien() <= 0) {
                errors.rejectValue("tien", "chiphingay.tien.invalid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
