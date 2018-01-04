package foodGroup4Quanly.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chinhanhmon;
import foodGroup4Quanly.service.ChiNhanhMonService;

@Component
public class PriceValidator implements Validator{

	@Autowired
	ChiNhanhMonService chiNhanhMonService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Chinhanhmon.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object b, Errors errors) {
		try {
			Chinhanhmon cnm = (Chinhanhmon) b;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gia", "NotEmpty");
			if (cnm.getGia() <= 0) {
				errors.rejectValue("gia", "gia.validate");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
