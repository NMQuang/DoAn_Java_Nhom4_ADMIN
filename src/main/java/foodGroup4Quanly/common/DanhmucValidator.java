package foodGroup4Quanly.common;

import foodGroup4Quanly.entity.Danhmuc;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DanhmucValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Danhmuc.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Danhmuc danhmuc = (Danhmuc) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");

        if(danhmuc.getTen() != null && danhmuc.getTen().length() < 3 || danhmuc.getTen().length() > 50) {
            errors.rejectValue("ten", "danhmuc.ten.invalid");
        }
    }
}
