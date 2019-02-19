package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentNum;
	
	
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	private Long roomNum;
	
	
	public Trainee() {

	}

	public Trainee(Long studentNum, String firstName, String lastName, Long roomNum) {

		this.studentNum = studentNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomNum = roomNum;
		
	}



	public Long getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Long studentNum) {
		this.studentNum = studentNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(Long roomNum) {
		this.roomNum = roomNum;
	}
	

}
