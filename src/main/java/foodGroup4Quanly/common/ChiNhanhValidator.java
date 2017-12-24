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

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sdt", "NotEmpty");
			if (khachHang.getSdt().length() < 10 || khachHang.getSdt().length() > 11) {
				errors.rejectValue("sdt", "Size.customerForm.sdt");
			}
//			if (userService.getUserByUsername(user.getUsername()) != null) {
//				errors.rejectValue("username", "Duplicate.userForm.username");
//			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			if (khachHang.getPassword().length() < 5 || khachHang.getPassword().length() > 45) {
				errors.rejectValue("password", "Size.customerForm.password");
			}
			if (!khachHang.getRePassword().equals(khachHang.getPassword())) {
				errors.rejectValue("rePassword", "Diff.customerForm.rePassword");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ten", "NotEmpty");
			if (khachHang.getTen().length() < 5 || khachHang.getTen().length() > 50) {
				errors.rejectValue("ten", "Size.customerForm.ten");
			}

//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty");

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "diaChi", "NotEmpty");
			if (khachHang.getDiaChi().length() < 5 || khachHang.getDiaChi().length() > 100) {
				errors.rejectValue("diaChi", "Size.customerForm.diaChi");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
