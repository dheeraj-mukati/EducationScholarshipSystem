package com.ess.controller;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ess.entity.Institute;
import com.ess.entity.Question2;
import com.ess.service.QuestionService;
import com.ess.validator.QuestionValidator;


@Controller
public class QuestionController {
	
	@Autowired QuestionValidator questionValidator;
	
	@Autowired QuestionService questionService;
	
	@RequestMapping(value="/question" ,method=RequestMethod.GET)
	public String question(ModelMap map){
		Question2 question =new Question2();
		map.put("question", question);
		map.put("quetionno", 1);
		return "uploadQuestion";
	}
	
	@RequestMapping(value="/uploadQuestion" ,method=RequestMethod.POST)
	public String uploadQuestion(@ModelAttribute("question") Question2 question,BindingResult result ,ModelMap map,HttpServletRequest request){
		
		questionValidator.validate(question, result);
		if(result.hasErrors()){
			map.put("quetionno", question.getQuestionNo());
			return "uploadQuestion";
		}
		question.setInstitute((Institute)request.getSession().getAttribute("institute"));
		questionService.uploadQuestion(question);
		Integer quetionno= question.getQuestionNo();
		Question2 question2= new Question2();
		map.put("question", question2);
		map.put("quploaded", quetionno);
		map.put("quetionno", ++quetionno);
		return "uploadQuestion";
	}
	
	@RequestMapping(value="/endUploadingQuestion" ,method=RequestMethod.GET)
	public String endUploadingQuestion(ModelMap map ,HttpServletRequest request){
		
		request.getSession().invalidate();
		return "redirect:setUpInstituteLogin";
	}
	

}
