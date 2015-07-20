package com.ess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ess.entity.Institute;
import com.ess.entity.Record;
import com.ess.entity.Result;
import com.ess.entity.User;
import com.ess.service.InstituteService;
import com.ess.service.QuestionService;
import com.ess.service.ResultService;
import com.ess.service.UserService;
import com.ess.entity.Question2;


@Controller
public class HomeController {

	//create instance of UserService
	@Autowired UserService userService;
	
	@Autowired InstituteService instituteService;
	
	@Autowired QuestionService questionService;
	
	@Autowired ResultService resultService;
		
	//method for user login form
	@RequestMapping(value="/instituteList" ,method=RequestMethod.GET)
	public String getInstituteList(HttpServletRequest request,ModelMap map){
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		
		map.put("instituteList", instituteService.getInstituteList());
		return "instituteList";
	}
	
	//method for user login form 
	@RequestMapping(value="/instituteInformation" ,method=RequestMethod.GET)
	public String getInstituteInformation(HttpServletRequest request,ModelMap map){
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		
		String instituteId=request.getParameter("instituteId");
		Institute institute=instituteService.getInstituteInformation(instituteId);
		map.put("institute", institute);
		return "instituteInformation";
	}
	
	@RequestMapping(value="/aboutTest" ,method=RequestMethod.GET)
	public String aboutTest(HttpServletRequest request,ModelMap map){
		
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		
		String instituteId=request.getParameter("instituteId");
		Institute institute=instituteService.getInstituteInformation(instituteId);
		map.put("institute", institute);
		return "aboutTest";
	}
	
	@RequestMapping(value="/test" ,method=RequestMethod.GET)
	public String startTest(HttpServletRequest request,ModelMap map){
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		
		String instituteId = request.getParameter("instituteId");
		
		List<Record> records = resultService.getRecord(Integer.valueOf(instituteId), Integer.valueOf(user.getUserID()));
		if(records.size() !=0){
			map.put("alreadyGiven", "You have already given the exam of this Institute");
			return "redirect:instituteList";
		}
		
		request.getSession().setAttribute("authInstitute", instituteService.getInstituteInformation(instituteId));
		Question2 question = questionService.getQuestion(Integer.valueOf(instituteId), 1);
		Result result = new Result();
		result.setQuestion(question);
		result.setMin(2);
		result.setSec(0);
		
		map.put("min", 2);
		map.put("sec", 0);
		map.put("option1",question.getOption1());
		map.put("option2",question.getOption2());
		map.put("option3",question.getOption3());
		map.put("option4",question.getOption4());
		map.put("questionNo",question.getQuestionNo());
		result.setQuestionNo(2);
		map.put("result", result);
		return "exam";
	}
	
	@RequestMapping(value="/nextQuestion" ,method=RequestMethod.POST)
	public String nextQuestion(@ModelAttribute("result") Result result ,HttpServletRequest request,ModelMap map){
		
		Institute institute=(Institute)request.getSession().getAttribute("authInstitute");
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		result.setUser(user);
		Question2 resultQuestion = questionService.getQuestion(institute.getInstituteID(), result.getQuestion().getQuestionNo());
		result.setQuestion(resultQuestion);
		result.setInstitute(institute);
		questionService.saveResult(result);
		Question2 question = questionService.getQuestion(institute.getInstituteID(), result.getQuestionNo());
		if(question == null){
			
			List<Result> results = resultService.getResults(user.getUserID(),Integer.valueOf(institute.getInstituteID()));
			map.put("min", result.getMin());
			map.put("sec", result.getSec());
			map.put("results", results);
			
			return "examSummary";
		}
		Integer questionNo = result.getQuestionNo();
		
		Result nextQuestion = new Result();
		nextQuestion.setQuestion(question);
		nextQuestion.setMin(result.getMin());
		nextQuestion.setSec(result.getSec());
		nextQuestion.setQuestionNo(++questionNo);
		
		map.put("option1",question.getOption1());
		map.put("option2",question.getOption2());
		map.put("option3",question.getOption3());
		map.put("option4",question.getOption4());
		map.put("questionNo",question.getQuestionNo());
		map.put("min", result.getMin());
		map.put("sec", result.getSec());
		map.put("result", nextQuestion);
		
		return "exam";
	}
	
	@RequestMapping(value="/changeAnswer" ,method=RequestMethod.POST)
	public String changeAnswer(@ModelAttribute("result") Result result ,HttpServletRequest request,ModelMap map){
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		Result result2 = resultService.getChangeQuestion(result.getQuestion().getQuestionID(), user.getUserID());
		Question2 question = result2.getQuestion();
		
		map.put("result", result2);
		map.put("optionSelected", result2.getOptionSelected());
		map.put("option1",question.getOption1());
		map.put("option2",question.getOption2());
		map.put("option3",question.getOption3());
		map.put("option4",question.getOption4());
		map.put("min", result.getMin());
		map.put("sec", result.getSec());
		
		return "changeAnswer";
		
	}
	
	@RequestMapping(value="/changeAnswerInDBMS" ,method=RequestMethod.POST)
	public String changeAnswerInDBMS(@ModelAttribute("result") Result result ,HttpServletRequest request,ModelMap map){
		
		Institute institute=(Institute)request.getSession().getAttribute("authInstitute");
		
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		Result result2 = resultService.getChangeQuestion(result.getQuestion().getQuestionID(), user.getUserID());
		System.out.println(result.getQuestion().getQuestionID());
		System.out.println(result2.getOptionSelected());
		result2.setOptionSelected(result.getOptionSelected());

		System.out.println(result2.getResultID());
		questionService.updateResult(result2);
		
		map.put("min", result.getMin());
		map.put("sec", result.getSec());
		
		map.put("answerChanged", "Answer has been successfully changed");
		
		List<Result> results = resultService.getResults(user.getUserID(),Integer.valueOf(institute.getInstituteID()));
		map.put("min", result.getMin());
		map.put("sec", result.getSec());
		map.put("results", results);
		
		return "examSummary";
		
	}
	
	@RequestMapping(value="/resultProcess" ,method=RequestMethod.GET)
	public String resultProcess(HttpServletRequest request,ModelMap map){
				
		User user=(User)request.getSession().getAttribute("authUser");
		if(user==null){
			return "welcome";
		}
		Institute institute=(Institute)request.getSession().getAttribute("authInstitute");
		
		Record record = resultService.processResult(user, institute);
		
		map.put("userName", user.getUserName());
		map.put("instituteName", institute.getInstituteName());
		map.put("totalQuestion", record.getTotalQuestion());
		map.put("yourScore", record.getPercentage());
		map.put("attemptedQuestion", record.getCorrectQuestion());
		map.put("passingScore", institute.getPassingScore());
		map.put("result", record.getResult());
		map.put("examDate", record.getExamDate());
		return "resultProcess";
		
	}
}
