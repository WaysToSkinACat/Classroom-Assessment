package com.qa.business.service;

public interface TraineeService {

	String getAllTrainee();

	String createTrainee(String account);
	
	String getATrainee(Long studentNum);

	String deleteTrainee(Long studentNum);

	String updateTrainee(Long studentNum, String account);
}

