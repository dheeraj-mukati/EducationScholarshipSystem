package com.ess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ess.dao.UserDAO;
import com.ess.entity.Institute;
import com.ess.entity.User;

@Service
public class UserService {

	@Autowired UserDAO userDAO;
	public void createUser(User user){
		userDAO.createUser(user);
		
	}
	
	public void createInstitute(Institute institute){
		userDAO.createInstitute(institute);
		
	}
	
	public List<Institute> checkInstitute(Institute institute){
	   return userDAO.checkInstitute(institute);
		
	}
	
	public List<User> checkUser(User user){
		
		List<User> list=userDAO.checkUser(user);
		return list;
	}
	
	public List<User> checkEmailExist(User user){
		return userDAO.checkEmailExist(user);
	}
	
	public List<User> getUserList(){
		return userDAO.getUserList();
	}
	
	public User findUserByID(String userID){
		
	List<User> list=userDAO.findUserByID(Integer.valueOf(userID));
	if(list.size()!=0){
		return list.get(0);
	}
	return null;
	}
	
	public void deleteUser(User user){
		
		userDAO.deleteUser(user);
	}
}
