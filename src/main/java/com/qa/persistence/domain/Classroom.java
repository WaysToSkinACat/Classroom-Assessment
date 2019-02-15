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
	public int getMaxClassNum() {
		return maxClassNum;
	}
	public void setMaxClassNum(int maxClassNum) {
		this.maxClassNum = maxClassNum;
	}
	public String getTrainees() {
		return trainees;
	}
	public void setTrainees(String trainees) {
		this.trainees = trainees;
	}
	
	
	
}
