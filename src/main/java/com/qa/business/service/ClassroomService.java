package com.qa.business.service;

public interface ClassroomService {
	
	String getAllClassroom();

	String createClassroom(String account);
	
	String getAClassroom(Long roomNum);

	String deleteClassroom(Long roomNum);

	String updateClassroom(Long roomNum, String account);
	
}