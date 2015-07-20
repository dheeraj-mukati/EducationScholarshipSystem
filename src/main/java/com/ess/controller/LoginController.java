package com.ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ess.entity.Institute;
import com.ess.entity.User;
import com.ess.service.UserService;
import com.ess.validator.InstituteValidator;
import com.ess.validator.LoginValidator;
import com.ess.validator.UserValidator;


@Controller
public class LoginController {
	
	//create instance of UserService
	@Autowired UserService userService;
	
	//create instance of UserValidator
	@Autowired UserValidator userValidator;
	
	//create instance of InstituteValidator
	@Autowired InstituteValidator instituteValidator;
	
	//create instance of LoginValidator
	@Autowired LoginValidator loginValidator;
	
	
	//method for user login form
	@RequestMapping(value="/welcome" ,method=RequestMethod.GET)
	public String welcome(){
				
		//return view 
		return "welcome";
	  }
		
	//method for user login form
	@RequestMapping(value="/loginUser" ,method=RequestMethod.GET)
	public String loginUser(ModelMap map){
			
			User user=new User();
			map.put("user", user);
			//return view 
			return "userLogin";
     }
	
	
	//method for user login form
	@RequestMapping(value="/logOut" ,method=RequestMethod.GET)
	public String logOut(HttpServletRequest request, ModelMap map){
				
			request.getSession().invalidate();
			//return view 
			return "welcome";
	     }
	//method for check user credentials in database
	@RequestMapping(value="/checkUser" ,method=RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user,BindingResult result ,ModelMap map,HttpServletRequest request){
			
			//check field error
			loginValidator.validate(user, result);
			if(result.hasErrors())
				return "userLogin";
			
			List<User> list=userService.checkUser(user);
			int size=list.size();
			if(size==0)
			{
				result.rejectValue("email", "email.required","wrong email/password");
				return "userLogin";
			}
			
			request.getSession().setAttribute("authUser", list.get(0));
			//return view
			return "redirect:instituteList";
	}
	
	//method for user registration form
	@RequestMapping(value="/createUser" ,method=RequestMethod.GET)
	public String createUser(ModelMap map){
		
		User user=new User();
		map.put("user", user);
		//return view
		return "userRegistration";
	}
	
	//method for save user in database
	@RequestMapping(value="/saveUser" ,method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user,BindingResult result ,ModelMap map){
		
		//check field error
		userValidator.validate(user, result);
		if(result.hasErrors())
			return "userRegistration";
		List<User> list= userService.checkEmailExist(user);
		int a=list.size();
		if(a!=0){
			result.rejectValue("email","email.required", "email already exist");
			return "userRegistration";
		}
		userService.createUser(user);
		//return view
		return "userLogin";
	}
	
	
	
	//method for institute registration form
	@RequestMapping(value="/createInstitute" ,method=RequestMethod.GET)
	public String makesure(ModelMap map){
		
		Institute institute=new Institute();
		map.put("institute", institute);
		//return view
		return "instituteRegistration";
	}

	//method for save institute in database
	@RequestMapping(value="/saveInstitute" ,method=RequestMethod.POST)
	public String wlcome(@ModelAttribute("institute") Institute institute,BindingResult result ,ModelMap map,HttpServletRequest request){
		
		//check field error
		instituteValidator.validate(institute, result);
		if(result.hasErrors())
			return "instituteRegistration";
		List<Institute> list=userService.checkInstitute(institute);
		if(list.size()!=0){
			result.rejectValue("email","email.required", "email already exist");
			return "instituteRegistration";
		}
		userService.createInstitute(institute);
		List<Institute> list2=userService.checkInstitute(institute);
		if(list2.size()!=0){
			request.getSession().setAttribute("institute", list2.get(0));
		}
		
		//return view
		return "aboutQuestionUpload";
	}
	
	//method for institute registration form
	@RequestMapping(value="/haveRead" ,method=RequestMethod.GET)
	public String have(ModelMap map){
		
		//return view
		return "redirect:/question";
	}
}
