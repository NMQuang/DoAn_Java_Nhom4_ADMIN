package foodGroup4Quanly.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.service.BanService;

@Component
public class BanValidator implements Validator{

	@Autowired
	BanService banService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Ban.class.equals(clazz);
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
			Ban ban = (Ban) b;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenBan", "NotEmpty");
			if (!ban.getTenBan().isEmpty() && (ban.getTenBan().length() < 2 || ban.getTenBan().length() > 100)) {
				errors.rejectValue("tenBan", "Size.tenBan");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tinhTrang", "NotEmpty");
//
//			if (ban.getChinhanh() != null){
//				if (banService.getInfoBan(ban.getChinhanh().getChiNhanhId()) == null)
//					errors.rejectValue("chinhanh", "Invalid.ChiNhanh");
//			} else {
//				errors.rejectValue("chinhanh", "NotEmpty");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
