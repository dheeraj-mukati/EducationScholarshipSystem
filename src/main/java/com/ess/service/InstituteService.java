package com.ess.service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ess.dao.InstituteDAO;
import com.ess.entity.Institute;
import com.ess.entity.Question2;


@Service
public class InstituteService {
	
	@Autowired InstituteDAO instituteDAO;
	
	public List<Institute> getInstituteList(){
		return instituteDAO.getInstituteList();
	}

	public Institute getInstituteInformation(String instituteId){
		
		return instituteDAO.getInstituteInformation(Integer.valueOf(instituteId));
	}
	
	public Institute findInstituteByID(String instituteId){
		
		List<Institute> institutes = instituteDAO.findInstituteByID(Integer.valueOf(instituteId));
		if(institutes.size()!=0){
			return institutes.get(0);
		}
		return null;
	}
	
	public void deleteInstitute(Institute institute){
		
		instituteDAO.deleteInstitute(institute);
	}
	
	public Institute checkInstitute(Institute institute){
		List<Institute> list = instituteDAO.checkInstitute(institute);
		if(list.size() != 0){
			return list.get(0);
		}
		return null;
		
	}
	public void editInstitute(Institute authinstitute,Institute institute){
		authinstitute.setEmail(institute.getEmail());
		authinstitute.setPassword(institute.getPassword());
		authinstitute.setInstituteName(institute.getInstituteName());
		authinstitute.setSuccessStory(institute.getSuccessStory());
		authinstitute.setCoursesOffered(institute.getCoursesOffered());
		authinstitute.setAddress1(institute.getAddress1());
		authinstitute.setAddress2(institute.getAddress2());
		authinstitute.setAddress3(institute.getAddress3());
		authinstitute.setContactNo1(institute.getContactNo1());
		authinstitute.setContactNo2(institute.getContactNo2());
		authinstitute.setContactNo3(institute.getContactNo3());
		authinstitute.setPassingScore(institute.getPassingScore());
		
		instituteDAO.updateInstitute(authinstitute);
	}
	
	public void updateQuestion(Question sessionQuestion, Question requestQuestion){
		
		
		
	}
	
	
	public List<Question2> getInstituteQuestions(Institute institute){
	
		return instituteDAO.getInstituteQuestions(institute.getInstituteID());
	}
	
	public List<Question2> getQuestionBQuestionNoAndInstituteID(Integer instituteID , Integer questionNo){
		
		return instituteDAO.getQuestionBQuestionNoAndInstituteID(instituteID, questionNo);
	}
	
	public void updateInstituteQuestion(Question2 sessionQuestion, Question2 question){
		
		sessionQuestion.setQuestion(question.getQuestion());
		sessionQuestion.setOption1(question.getOption1());
		sessionQuestion.setOption2(question.getOption2());
		sessionQuestion.setOption3(question.getOption3());
		sessionQuestion.setOption4(question.getOption4());
		
		if(question.getCorrectOption().equals("op1"))
			sessionQuestion.setCorrectOption(question.getOption1());
		
		if(question.getCorrectOption().equals("op2"))
			sessionQuestion.setCorrectOption(question.getOption2());
		
		if(question.getCorrectOption().equals("op3"))
			sessionQuestion.setCorrectOption(question.getOption3());
		
		if(question.getCorrectOption().equals("op4"))
			sessionQuestion.setCorrectOption(question.getOption4());
		
		
		instituteDAO.updateInstituteQuestion(sessionQuestion);
	}
}
