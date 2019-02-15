package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String getAllClassroom();

	String createClassroom(String account);
	
	String getAClassroom(Long roomNum);

	String deleteClassroom(Long roomNum);

	String updateClassroom(Long roomNum, String account);
	
}
