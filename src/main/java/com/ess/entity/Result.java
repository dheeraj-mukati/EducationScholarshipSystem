package com.ess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;


@Entity
@Table(name="result")
public class Result {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resultID")
	private Integer resultID;
	
	@Column
	private String optionSelected;
	
	@ManyToOne
	@JoinColumn(name="questionID")
	private Question2 question;
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@Transient
	private Integer min;
	
	@Transient
	private Integer sec;
	
	@Transient
	private Integer questionNo;
	
	@ManyToOne
	@JoinColumn(name="instituteID")
	private Institute institute;

	public Integer getResultID() {
		return resultID;
	}

	public void setResultID(Integer resultID) {
		this.resultID = resultID;
	}

	public String getOptionSelected() {
		return optionSelected;
	}

	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	public Question2 getQuestion() {
		return question;
	}

	public void setQuestion(Question2 question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getSec() {
		return sec;
	}

	public void setSec(Integer sec) {
		this.sec = sec;
	}

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	
	
}
