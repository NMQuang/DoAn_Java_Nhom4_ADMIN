package foodGroup4Quanly.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodGroup4Quanly.entity.Mon;
import foodGroup4Quanly.service.DanhMucService;

@Component
public class MonValidator implements Validator{

	@Autowired
	DanhMucService danhMucService;
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Mon.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		try {
			Mon mon = (Mon)target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "donViTinh", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "moTa", "NotEmpty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hinhAnh", "NotEmpty");
			if(mon.getDanhmuc() != null){
				if(danhMucService.get(mon.getDanhmuc().getDanhMucId())== null)
					errors.rejectValue("danhmuc", "Invalid.Category");
			}else
				errors.rejectValue("danhmuc", "NotEmpty");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
