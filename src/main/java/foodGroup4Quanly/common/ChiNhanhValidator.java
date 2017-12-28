package foodGroup4Quanly.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.service.BranchService;

@Component
public class ChiNhanhValidator implements Validator{

	@Autowired
	BranchService chiNhanhService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Chinhanh.class.equals(clazz);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object cn, Errors errors) {
		try {
			Chinhanh chiNhanh = (Chinhanh) cn;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");
			if (chiNhanh.getTen().length() < 2 || chiNhanh.getTen().length() > 100) {
				errors.rejectValue("ten", "Size.ten");
			}
//			if (userService.getUserByUsername(user.getUsername()) != null) {
//				errors.rejectValue("username", "Duplicate.userForm.username");
//			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diaChi", "NotEmpty");
			if (chiNhanh.getDiaChi().length() < 2 || chiNhanh.getDiaChi().length() > 255) {
				errors.rejectValue("diaChi", "Size.diaChi");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dienThoai", "NotEmpty");
			if (chiNhanh.getDienThoai().length() < 9 || chiNhanh.getDienThoai().length() > 12) {
				errors.rejectValue("dienThoai", "Size.dienThoai");
			}

			if (chiNhanh.getTinhthanh() != null){
				if (chiNhanhService.getInfoChiNhanh(chiNhanh.getTinhthanh().getTinhThanhId()) == null)
					errors.rejectValue("tinhthanh", "Invalid.TinhThanh");
			} else {
				errors.rejectValue("tinhthanh", "NotEmpty");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
