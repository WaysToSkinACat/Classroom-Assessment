package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentNum;
	
//	@OneToMany(mappedBy = "trainee", cascade=CascadeType.ALL)
//	private List<Classroom> recipes = new ArrayList<Classroom>();
	
	@Column(length = 50)
	private String FirstName;
	@Column(length = 50)
	private String lastName;

	public Trainee() {

	}

	public Trainee(Long studentNum, String firstName, String lastName) {

		this.studentNum = studentNum;
		FirstName = firstName;
		this.lastName = lastName;
	}

	public Long getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Long studentNum) {
		this.studentNum = studentNum;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
