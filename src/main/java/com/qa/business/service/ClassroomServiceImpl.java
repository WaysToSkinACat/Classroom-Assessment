package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService{

	@Inject
	private ClassroomRepository repo;
	
	
	public String getAllClassroom() {
		
		return repo.getAllClassroom();
	}

	public String createClassroom(String account) {

		return repo.createClassroom(account);
	}

	public String getAClassroom(Long roomNum) {

		return repo.getAClassroom(roomNum);
	}

	public String deleteClassroom(Long roomNum) {

		return repo.deleteClassroom(roomNum);
	}

	public String updateClassroom(Long roomNum, String account) {

		return repo.deleteClassroom(roomNum);
	}

}
