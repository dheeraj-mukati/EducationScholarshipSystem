package com.ess.service;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ess.dao.QuestionDAO;
import com.ess.entity.Question2;
import com.ess.entity.Result;


@Service
public class QuestionService {

	@Autowired QuestionDAO questionDAO;
	
	public void uploadQuestion(Question2 question){
		
		if(question.getCorrectOption().equals("op1"))
			question.setCorrectOption(question.getOption1());
		
		if(question.getCorrectOption().equals("op2"))
			question.setCorrectOption(question.getOption2());
		
		if(question.getCorrectOption().equals("op3"))
			question.setCorrectOption(question.getOption3());
		
		if(question.getCorrectOption().equals("op4"))
			question.setCorrectOption(question.getOption4());
		
		questionDAO.uploadQuestion(question);
		
		
	}
	
	public Question2 getQuestion(Integer instituteID , Integer questionNo){
		
		List<Question2> questions = questionDAO.getQuestion(instituteID, questionNo);
		
		if(questions.size()!=0){
			return questions.get(0);
		}
		
		return null;
	}
	
	public void saveResult(Result result){
		
		questionDAO.saveResult(result);
	}
	
	public void updateResult(Result result){
		
		questionDAO.updateResult(result);
	}
	
	public Question2 getQuestionByQuestionID(Integer questionID){
		
		return questionDAO.getQuestionByQuestionID(questionID);
		
	}

}
