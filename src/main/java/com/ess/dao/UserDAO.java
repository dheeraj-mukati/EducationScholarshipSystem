package com.ess.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ess.entity.Institute;
import com.ess.entity.User;

@Repository
public class UserDAO {
	
	@Autowired HibernateTemplate hibernateTemplate;  
	
	public void createUser(User user){
	
		hibernateTemplate.save(user);
	}
	
	public void createInstitute(Institute institute){
		
		hibernateTemplate.save(institute);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserList(){
		
		return hibernateTemplate.find(" FROM "+ User.class.getName());
	}
	
	@SuppressWarnings("unchecked")
	public List<Institute> checkInstitute(Institute institute){
		
		List<Institute> list= hibernateTemplate.find(" FROM "+ Institute.class.getName()+" where email='"+institute.getEmail()+"'");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> checkUser(User user){
		
		List<User> list= hibernateTemplate.find(" FROM "+ User.class.getName()+" where email='"+user.getEmail()+"' and password='"+user.getPassword()+"'");
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> checkEmailExist(User user){
		
		List<User> list= hibernateTemplate.find(" FROM "+ User.class.getName()+" where email='"+user.getEmail()+"'");
		return list;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findUserByID(Integer userID){
		
		List<User> list= hibernateTemplate.find(" FROM "+ User.class.getName()+" where userID='"+userID+"'");
		return list;
		
	}
	
	public void deleteUser(User user){
		
		hibernateTemplate.delete(user);
	}

}
