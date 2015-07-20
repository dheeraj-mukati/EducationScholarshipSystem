package com.ess.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ess.entity.Record;
import com.ess.entity.Result;
import com.ess.entity.User;

@Repository
public class ResultDAO {
	
	@Autowired HibernateTemplate hibernateTemplate;
	
	
	@SuppressWarnings("unchecked")
	public List<Result> getResults(Integer userID, Integer instituteID){
		
		return hibernateTemplate.find(" FROM "+ Result.class.getName()+" where userID='"+userID+"' and instituteID='"+instituteID+"'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Result> getChangeQuestion(Integer questionID , Integer userID){
		
		return  hibernateTemplate.find(" FROM "+ Result.class.getName()+" where questionID='"+questionID+"' and userID='"+userID+"'");
	}
	
	public void saveRecord(Record record){
		hibernateTemplate.save(record);
	}
	
	@SuppressWarnings("unchecked")
	public List<Record> getRecord(Integer instituteID , Integer userID){
		
		return  hibernateTemplate.find(" FROM "+ Record.class.getName()+" where instituteID='"+instituteID+"' and userID='"+userID+"'");
	}

}
