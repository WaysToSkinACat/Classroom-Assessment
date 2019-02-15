package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	@Inject
	private TraineeRepository repo;
	
	
	public String getAllTrainee() {
		
		return repo.getAllTrainee();
	}

	public String createTrainee(String account) {

		return repo.createTrainee(account);
	}

	public String getATrainee(Long studentNum) {

		return repo.getATrainee(studentNum);
	}

	public String deleteTrainee(Long studentNum) {

		return repo.deleteTrainee(studentNum);
	}

	public String updateTrainee(Long studentNum, String account) {

		return repo.deleteTrainee(studentNum);
	}

}