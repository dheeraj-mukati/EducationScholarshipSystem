package com.ess.dao;

import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ess.entity.Institute;
import com.ess.entity.Question2;

@Repository
public class InstituteDAO {
	
	@Autowired HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Institute> getInstituteList(){
		
		return hibernateTemplate.find(" FROM "+Institute.class.getName());
	}
	
	public Institute getInstituteInformation(Integer instituteId){
		
		return (Institute) hibernateTemplate.get(Institute.class.getName(), instituteId);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Institute> findInstituteByID(Integer instituteID){
		
		List<Institute> list= hibernateTemplate.find(" FROM "+ Institute.class.getName()+" where instituteID='"+instituteID+"'");
		return list;
		
	}
	
	public void deleteInstitute(Institute institute){
		
		hibernateTemplate.delete(institute);
	}
	
	@SuppressWarnings("unchecked")
	public List<Institute> checkInstitute(Institute institute){
		
		List<Institute> list= hibernateTemplate.find(" FROM "+ Institute.class.getName()+" where email='"+institute.getEmail()+"' and password='"+institute.getPassword()+"'");
		return list;
	}

	public void updateInstitute(Institute institute){
		
		hibernateTemplate.saveOrUpdate(institute);
	}
	
	@SuppressWarnings("unchecked")
	public List<Question2> getInstituteQuestions(Integer instituteID){
		
		
		//List<Question> list= hibernateTemplate.find(" FROM "+ Question.class.getName()+" where instituteID='"+instituteID+"'");
		List<Question2> questions = hibernateTemplate.find(" FROM "+ Question2.class.getName()+" where instituteID='"+instituteID+"'");
		return questions;
	}
	
	@SuppressWarnings("unchecked")
	public List<Question2> getQuestionBQuestionNoAndInstituteID(Integer instituteID , Integer questionNo){
		
		List<Question2> list= hibernateTemplate.find(" FROM "+ Question2.class.getName()+" where instituteID='"+instituteID+"' and questionNo='"+questionNo+"'");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void updateInstituteQuestion(Question2 question){
		
		hibernateTemplate.saveOrUpdate(question);
		
	}
}
