package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomNum;
	@Column(length = 50)
	private String trainer;
	@Column(length = 3)
	private Integer maxClassNum;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "roomNum", cascade=CascadeType.ALL)
	private List<Trainee> student = new ArrayList<Trainee>();


	public Classroom(Long roomNum, String trainer, Integer maxClassNum) {
		
		this.roomNum = roomNum;		
		this.trainer = trainer;
		this.maxClassNum = maxClassNum;

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

	public Integer getMaxClassNum() {
		return maxClassNum;
	}

	public void setMaxClassNum(Integer maxClassNum) {
		this.maxClassNum = maxClassNum;
	}


}
