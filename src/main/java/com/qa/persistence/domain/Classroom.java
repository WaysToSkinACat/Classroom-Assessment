package com.qa.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Classroom {

	

	public Classroom(Long roomNum, String trainer, int maxClassNum, String trainees) {
		
		this.roomNum = roomNum;
		this.trainer = trainer;
		this.maxClassNum = maxClassNum;
		this.trainees = trainees;
	}
	private Long roomNum;
	private String trainer;
	private int maxClassNum;
	private String trainees;
	
	
	public Long getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(Long roomNum) {
		this.roomNum = roomNum;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public int getmaxClassNum() {
		return maxClassNum;
	}
	public void setmaxClassNum(int maxClassNum) {
		this.maxClassNum = maxClassNum;
	}
	public String gettrainees() {
		return trainees;
	}
	public void settrainees(String trainees) {
		this.trainees = trainees;
	}
	
	
	
}
