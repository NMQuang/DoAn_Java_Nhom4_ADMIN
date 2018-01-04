package foodGroup4Quanly.common;

import foodGroup4Quanly.dto.SuaDanhMucDto;
import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SuaDanhmucValidator implements Validator {

    @Autowired
    DanhMucService danhMucService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SuaDanhMucDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        try {
            SuaDanhMucDto suaDmDto = (SuaDanhMucDto) o;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newten", "NotEmpty");

            if (suaDmDto.getNewten() != null && (suaDmDto.getNewten().length() < 3 || suaDmDto.getNewten().length() > 50)) {
                errors.rejectValue("newten", "danhmuc.ten.invalid");
                System.out.println("errors");
            }

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idDm", "NotEmpty");

            if(suaDmDto.getIdDm() != null) {
                if (danhMucService.get(suaDmDto.getIdDm()) == null) {
                    errors.rejectValue("idDm", "danhmuc.id.notfound");
                }
            }
        }
        catch (Exception e) {

        }
    }
}
