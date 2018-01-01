package foodGroup4Quanly.common;

import foodGroup4Quanly.dto.ThemDanhMucDto;
import foodGroup4Quanly.entity.Danhmuc;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ThemDanhmucValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ThemDanhMucDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ThemDanhMucDto themDmDto = (ThemDanhMucDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");

        if(themDmDto.getTen() != null && themDmDto.getTen().length() < 3 || themDmDto.getTen().length() > 50) {
            errors.rejectValue("ten", "danhmuc.ten.invalid");
        }
    }
}
