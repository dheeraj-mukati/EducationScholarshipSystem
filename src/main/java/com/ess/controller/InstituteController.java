package com.ess.controller;

import java.util.List;

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
import com.ess.service.InstituteService;
import com.ess.service.UserService;
import com.ess.validator.InstituteValidator;
import com.ess.validator.LoginValidator;
import com.ess.validator.QuestionValidator;

@Controller
public class InstituteController {

	//create instance of UserService
	@Autowired UserService userService;
	
	@Autowired InstituteService instituteService;
	
	//create instance of LoginValidator
	@Autowired LoginValidator loginValidator;
	
	//create instance of InstituteValidator
	@Autowired InstituteValidator instituteValidator;
	
	@Autowired QuestionValidator questionValidator;
	
	//method for user login form
	@RequestMapping(value="/setUpInstituteLogin" ,method=RequestMethod.GET)
	public String InstituteLoginForm(HttpServletRequest request,ModelMap map){
				
		Institute institute=new Institute();
		map.put("institute", institute);
		return "instituteLogin";
	}
	
	@RequestMapping(value="/submitInstituteLoginForm" ,method=RequestMethod.POST)
	public String checkInstitute(@ModelAttribute("institute") Institute institute,BindingResult result ,HttpServletRequest request,ModelMap map){
				
		loginValidator.validate(institute, result);
		if(result.hasErrors()){
			return "instituteLogin";
		}
		Institute authinstitute = instituteService.checkInstitute(institute);
		if(authinstitute == null){
			result.rejectValue("email", "email.required","wrong email/password");
			return "instituteLogin";
		}
		request.getSession().setAttribute("sessionInstitute", authinstitute);
		return "instituteHome";
	}
	
	@RequestMapping(value="/setUpeditInstituteForm" ,method=RequestMethod.GET)
	public String editInstitute(ModelMap map,HttpServletRequest request){
	
		Institute institute= (Institute)request.getSession().getAttribute("sessionInstitute");
		if(institute == null){
			return "redirect:setUpInstituteLogin";
		}
		map.put("institute", institute);
		return "editInstitute";
	}
	
	@RequestMapping(value="/submitEditInstituteForm" ,method=RequestMethod.POST)
	public String editInstituteInDBMS(@ModelAttribute("institute") Institute institute,BindingResult result ,HttpServletRequest request,ModelMap map){
				
		instituteValidator.validate(institute, result);
		if(result.hasErrors()){
			return "editInstitute";
		}
		Institute authinstitute= (Institute)request.getSession().getAttribute("sessionInstitute");
		if(authinstitute == null){
			return "redirect:setUpInstituteLogin";
		}
		if(!authinstitute.getEmail().equals(institute.getEmail())){
			List<Institute> list=userService.checkInstitute(institute);
			if(list.size()!=0){
				result.rejectValue("email","email.required", "email already exist");
				return "editInstitute";
			}
		}
		instituteService.editInstitute(authinstitute, institute);
		map.put("success", "profile updated successfully");
		return "instituteHome";
	}
	
	@RequestMapping(value="/instituteQuestionsList" ,method=RequestMethod.GET)
	public String getInstitutQuestions(ModelMap map,HttpServletRequest request){
	
		
		Institute institute= (Institute)request.getSession().getAttribute("sessionInstitute");
		if(institute == null){
			return "redirect:setUpInstituteLogin";
		}
		
		List<Question2> questionsList = instituteService.getInstituteQuestions(institute);
		System.out.println("list size= "+questionsList.size());
		map.put("questionsList", questionsList);
		return "InstituteQuestionList";
	}
	
	@RequestMapping(value="/setUpeditQuestionForm" ,method=RequestMethod.GET)
	public String editQuestion(ModelMap map,HttpServletRequest request){
	
		String questionNo = request.getParameter("questionNo");
		Institute institute= (Institute)request.getSession().getAttribute("sessionInstitute");
		
		if(institute == null){
			return "redirect:setUpInstituteLogin";
		}
		
		List<Question2> questionsList = instituteService.getQuestionBQuestionNoAndInstituteID(Integer.valueOf(institute.getInstituteID()), Integer.valueOf(questionNo));
		request.getSession().setAttribute("question", questionsList.get(0));
		
		map.put("question", questionsList.get(0));
		return "editQuestion";
	}

	@RequestMapping(value="/submitEditQuestionForm" ,method=RequestMethod.POST)
	public String updateInstitute(@ModelAttribute("question") Question2 question,BindingResult result ,HttpServletRequest request,ModelMap map){
				
		questionValidator.validate(question, result);
		if(result.hasErrors()){
			return "editQuestion";
		}
		Question2 sessionQuestion = (Question2)request.getSession().getAttribute("question");
		
		instituteService.updateInstituteQuestion(sessionQuestion, question);
		map.put("success", "Question has been succesfully updated");
		return "redirect:instituteQuestionsList";
	}
	
	//method for user login form
	@RequestMapping(value="/instituteLogOut" ,method=RequestMethod.GET)
	public String instituteLogOut(HttpServletRequest request,ModelMap map){
					
		request.getSession().invalidate();
		Institute institute=new Institute();
		map.put("institute", institute);
		return "instituteLogin";
	}
}