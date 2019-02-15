package com.qa.persistence.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

public class ClassroomDBRepository implements ClassroomRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	
	public String getAllClassroom() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Classroom>) query.getResultList());
	}

	public String createClassroom(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAClassroom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteClassroom(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateClassroom(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;		
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

}
