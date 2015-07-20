package com.ess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="record")
public class Record {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recordID")
	private Integer recordID;
	
	@Column
	private Integer totalQuestion;
	
	@Column
	private Integer correctQuestion;
	
	@Column
	private Float percentage;
	
	@Column
	private String result;
	
	@Column
	private Date examDate;
	
	@ManyToOne
	@JoinColumn(name="instituteID")
	private Institute institute;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	public Integer getRecordID() {
		return recordID;
	}

	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	public Integer getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(Integer totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Integer getCorrectQuestion() {
		return correctQuestion;
	}

	public void setCorrectQuestion(Integer correctQuestion) {
		this.correctQuestion = correctQuestion;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	
	
}
