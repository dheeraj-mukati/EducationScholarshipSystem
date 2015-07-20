package com.ess.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ess.dao.QuestionDAO;
import com.ess.dao.ResultDAO;
import com.ess.entity.Institute;
import com.ess.entity.Record;
import com.ess.entity.Result;
import com.ess.entity.User;
import com.ess.entity.Question2;


@Service
public class ResultService {
	
	@Autowired ResultDAO resultDAO;
	
	@Autowired QuestionDAO questionDAO;
	
	public List<Result> getResults(Integer userID, Integer instituteID){
		
		return resultDAO.getResults(userID,instituteID);
	}

	public Result getChangeQuestion(Integer questionID , Integer userID){
		
		List<Result> results = resultDAO.getChangeQuestion(questionID , userID);
		if(results.size()!=0)
		{
			return results.get(0);
		}
		return null;
	}
	
	public Record processResult(User user , Institute institute){
		
		Iterator<Result> results = resultDAO.getResults(user.getUserID(),institute.getInstituteID()).iterator();
		
		Iterator<Question2> questions = questionDAO.getQuestionByInstituteId(institute.getInstituteID()).iterator();
		
		Date examDate = new Date();
		Integer totalQuestion=0;
		Integer correctQuestion=0;
		
		while(results.hasNext() && questions.hasNext()){
			
			Result result = results.next();
			Question2 question = questions.next();
			
			if(result.getOptionSelected().equals(question.getCorrectOption())){
				++ correctQuestion;
			}
			++ totalQuestion;
			
		}
		Float percenteage = (((float)correctQuestion)/totalQuestion)*100;
		Record record = new Record();
		record.setUser(user);
		record.setInstitute(institute);
		record.setTotalQuestion(totalQuestion);
		record.setCorrectQuestion(correctQuestion);
		record.setPercentage(percenteage);
		record.setExamDate(examDate);
		if(percenteage < (float)institute.getPassingScore()){
			record.setResult("Fail");
		}else{
			record.setResult("Pass");
		}
		resultDAO.saveRecord(record);
		
		List<Record> records = resultDAO.getRecord(institute.getInstituteID() , user.getUserID());
		
		if(records.size()!=0){
			return records.get(0);
		}
		
		return null;
		
	}
	
	public List<Record> getRecord(Integer instituteID , Integer userID){
		return resultDAO.getRecord(instituteID, userID);
	}
}
