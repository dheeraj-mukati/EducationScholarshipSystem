package com.ess.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ess.entity.Question2;

public class QuestionValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Question2.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		Question2 question = (Question2) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "question","userName.required","Question required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "option1","userName.required","Option1 required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "option2","userName.required","Option2 required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "option3","userName.required","Option3 required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "option4","userName.required","Option4 required");
		
		if(question.getCorrectOption() !=null && question.getCorrectOption().equals("-1")){
			errors.rejectValue("correctOption","userName.required","Select Correct Option");
		}
		
		if(StringUtils.hasText(question.getOption1()) && StringUtils.hasText(question.getOption2()) && StringUtils.hasText(question.getOption3()) && StringUtils.hasText(question.getOption4()))
			if(
				  question.getOption1().equals(question.getOption2())
				  || question.getOption1().equals(question.getOption3())
				  || question.getOption1().equals(question.getOption4())
				  || question.getOption2().equals(question.getOption3())
				  || question.getOption2().equals(question.getOption4())
				  || question.getOption3().equals(question.getOption4())
				  )
				  {
			  errors.rejectValue("questionNo", "userName.required","No two answers can be same");
			
		}
		
		
	}

}
