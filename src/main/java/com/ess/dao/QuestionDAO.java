
package com.ess.dao;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ess.entity.Question2;
import com.ess.entity.Result;

@Repository
public class QuestionDAO {
	
	@Autowired HibernateTemplate hibernateTemplate;
	
	public void uploadQuestion(Question2 question){
		hibernateTemplate.save(question);
	}
	
	@SuppressWarnings("unchecked")
	public List<Question2> getQuestion(Integer instituteID , Integer questionNo){
		
		List<Question2> questions = hibernateTemplate.find(" FROM "+ Question2.class.getName()+" where instituteID='"+instituteID+"' and questionNo='"+questionNo+"'");
		return questions;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Question2> getQuestionByInstituteId(Integer instituteID){
		
		List<Question2> questions = hibernateTemplate.find(" FROM "+ Question2.class.getName()+" where instituteID='"+instituteID+"'");
		return questions;
		
	}

	public void saveResult(Result result){
		
		hibernateTemplate.save(result);
	}
	
    public void updateResult(Result result){
		
		hibernateTemplate.saveOrUpdate(result);
	}
	
	public Question2 getQuestionByQuestionID(Integer questionID){
		
		return (Question2)hibernateTemplate.get(Question.class.getName(), questionID);
	}
}
