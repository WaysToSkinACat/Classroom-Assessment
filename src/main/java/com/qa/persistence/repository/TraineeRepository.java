package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String getAllTrainee();

	String createTrainee(String account);
	
	String getATrainee(Long studentNum);

	String deleteTrainee(Long studentNum);

	String updateTrainee(Long studentNum, String account);
}
