package com.ess.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ess.entity.Institute;

public class InstituteValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Institute.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
        Institute institute =(Institute)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instituteName","userName.required","Institute Name required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email","password.required","email required");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.required","password required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "address.required","confirm password required");
		ValidationUtils.rejectIfEmpty(errors, "address1", "contNO.required","address required");
		ValidationUtils.rejectIfEmpty(errors, "successStory", "contNO.required","Success Story required");
		ValidationUtils.rejectIfEmpty(errors, "coursesOffered", "contNO.required","Courssess Offered required");
		ValidationUtils.rejectIfEmpty(errors, "contactNo1", "contNO.required","contact required");
		ValidationUtils.rejectIfEmpty(errors, "passingScore", "contNO.required","Passing Score required");
		
		
		
		if(!institute.getPassword().equals(institute.getConfirmPassword())){
			errors.rejectValue("confirmPassword","confirmPassword.required", "Confirm password not matched");
			
		}
		if(StringUtils.hasText(institute.getEmail())){
		validateEmail(institute.getEmail(), errors);
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


