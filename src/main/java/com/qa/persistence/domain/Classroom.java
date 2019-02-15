package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomNum;
	@Column(length = 50)
	private String trainer;
	@Column(length = 3)
	private int maxClassNum;
	@Column(length = 50)
	private String trainees;

	public Classroom(Long roomNum, String trainer, int maxClassNum, String trainees) {

		this.roomNum = roomNum;

		this.trainer = trainer;
		this.maxClassNum = maxClassNum;
		this.trainees = trainees;
	}

	public Classroom() {

	}

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
