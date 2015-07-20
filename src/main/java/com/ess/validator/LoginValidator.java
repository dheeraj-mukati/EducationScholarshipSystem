package com.ess.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ess.entity.User;


public class LoginValidator implements Validator {

	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","userName.required","email required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required","password required");

		
	}

}
