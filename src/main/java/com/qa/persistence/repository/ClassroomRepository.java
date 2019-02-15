package com.qa.persistence.repository;

public interface ClassroomRepository {
	
	String getAllClassroom();

	String createClassroom(String account);
	
	String getAClassroom(Long id);

	String deleteClassroom(Long id);

	String updateClassroom(Long id, String account);
	
}
