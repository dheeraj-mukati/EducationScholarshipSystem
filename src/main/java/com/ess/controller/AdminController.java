package com.ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ess.entity.Institute;
import com.ess.entity.User;
import com.ess.service.InstituteService;
import com.ess.service.QuestionService;
import com.ess.service.ResultService;
import com.ess.service.UserService;

@Controller
public class AdminController {

	@Autowired UserService userService;
	
	@Autowired InstituteService instituteService;
	
	@Autowired ResultService resultService;
	
	@Autowired QuestionService questionService;
	
	
    	//method for user login form
		@RequestMapping(value="/setUpAdminLogin" ,method=RequestMethod.GET)
		public String adminLofinForm(HttpServletRequest request,ModelMap map){
			
			return "adminLogin";
		}
		
		//method for user login form
		@RequestMapping(value="/aboutUs" ,method=RequestMethod.GET)
		public String aboutUs(HttpServletRequest request,ModelMap map){
					
			return "AboutUs";
		}
	
	    //method for user login form
		@RequestMapping(value="/loginSubmitAdminForm" ,method=RequestMethod.POST)
		public String checkAdmin(HttpServletRequest request,ModelMap map){
			
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			if(userName.equals("admin") && password.equals("admin")){
				return "adminHome";
			}
			map.put("error", "username/password invalid");
			return "adminLogin";
		}
		
		//method for user login form
		@RequestMapping(value="/getInstituteList" ,method=RequestMethod.GET)
		public String getInstituteList(HttpServletRequest request,ModelMap map){
					
			List<Institute> institutes = instituteService.getInstituteList();
			map.put("instituteList", institutes);
			return "manageInstitute";
		}
		
		//method for user login form
		@RequestMapping(value="/getUserList" ,method=RequestMethod.GET)
		public String getUserList(HttpServletRequest request,ModelMap map){

			List<User> users = userService.getUserList();
			map.put("userList", users);
			return "manageUser";
		}
		
		//method for user login form
		@RequestMapping(value="/deleteUser" ,method=RequestMethod.GET)
		public String deleteUser(HttpServletRequest request,ModelMap map){

			
			String userID = request.getParameter("userID");
			User user = userService.findUserByID(userID);
			userService.deleteUser(user);
			
			map.put("success", "User has been successfully deleted");
			List<User> users = userService.getUserList();
			map.put("userList", users);
			return "manageUser";
		}
		
		//method for user login form
		@RequestMapping(value="/deleteInstitute" ,method=RequestMethod.GET)
		public String deleteInstitute(HttpServletRequest request,ModelMap map){

			String instituteID = request.getParameter("instituteID");
			Institute institute = instituteService.findInstituteByID(instituteID);
			instituteService.deleteInstitute(institute);
			
			map.put("success", "Institute has been successfully deleted");
			
			List<Institute> institutes = instituteService.getInstituteList();
			map.put("instituteList", institutes);
			return "manageInstitute";
		}

}
