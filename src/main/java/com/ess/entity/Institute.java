package com.ess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="institute")
public class Institute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instituteID")
	private Integer instituteID;
	
	@Column
	private String instituteName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Column
	private String address1;
	
	@Column
	private String address2;
	
	@Column
	private String address3;
	
	@Column
	private String successStory;
	
	@Column
	private String coursesOffered;
	
	@Column
	private Long contactNo1;
	
	@Column
	private Long contactNo2;
	
	@Column
	private Long contactNo3;
	
	@Column
	private Integer passingScore;

	public Integer getInstituteID() {
		return instituteID;
	}

	public void setInstituteID(Integer instituteID) {
		this.instituteID = instituteID;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getSuccessStory() {
		return successStory;
	}

	public void setSuccessStory(String successStory) {
		this.successStory = successStory;
	}

	public String getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(String coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public Long getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(Long contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public Long getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(Long contactNno2) {
		this.contactNo2 = contactNno2;
	}

	public Long getContactNo3() {
		return contactNo3;
	}

	public void setContactNo3(Long contactNno3) {
		this.contactNo3 = contactNno3;
	}

	public Integer getPassingScore() {
		return passingScore;
	}

	public void setPassingScore(Integer passingScore) {
		this.passingScore = passingScore;
	}

}
