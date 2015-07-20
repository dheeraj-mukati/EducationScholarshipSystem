package com.ess.validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ess.entity.User;
import com.ess.service.UserService;



public class UserValidator implements Validator{

	
	@Autowired UserService userServiceImpl;
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		User user=(User)target;
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","userName.required","userName required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","userName.required","email required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","password.required","password required");
		ValidationUtils.rejectIfEmpty(errors, "gender", "gender.required","gender required");
		ValidationUtils.rejectIfEmpty(errors, "address", "address.required","address required");
		ValidationUtils.rejectIfEmpty(errors, "contNO", "contNO.required","contact no required");
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			errors.rejectValue("confirmPassword","confirmPassword.required", "Confirm password not matched");
		}
		
		if(StringUtils.hasText(user.getContNO())){
		validatePhoneNumber(user.getContNO(), errors);
		}
		if(StringUtils.hasText(user.getEmail())){
		validateEmail(user.getEmail(), errors);
		}
	}
	
	public static void validatePhoneNumber(String data,Errors errors) {
        if(data!=null){
         Pattern p = Pattern.compile("^[0-9]{10}",Pattern.CASE_INSENSITIVE);
          Matcher m = p.matcher(data);
          boolean b = m.matches();
         if(!b){
             errors.rejectValue("contNO",
                        "error.phone.rule","Number must have 10 digit");
         }
         
        }
	}
       public static void validateEmail(String data, Errors errors){   
             //final String EMAIL_PATTERN = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.){1,2}+[A-Z]{2,4}$";
              final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
             Pattern p = Pattern.compile(EMAIL_PATTERN,Pattern.CASE_INSENSITIVE);
              Matcher m = p.matcher(data!=null?data:"");
              boolean b = m.matches();
           
              if(!b){
              errors.rejectValue("email",
                            "error.email.required","email is not valid");
             }
             
           
        }

  }
