package com.qa.persistence.repository;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	
	public String getAllClassroom() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Classroom>) query.getResultList());
	}
	
	@Transactional(REQUIRED)
	public String createClassroom(String account) {
		Classroom aClassroom = util.getObjectForJSON(account, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	public String getAClassroom(Long roomNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteClassroom(Long roomNum) {
		manager.remove(manager.find(Classroom.class, roomNum));
		return "{\"message\": \"account has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long roomNum, String account) {
		Classroom updates = util.getObjectForJSON(account, Classroom.class);
		Classroom toUpdate = manager.find(Classroom.class, roomNum);
		
		if (updates.getRoomNum() != null) {toUpdate.setRoomNum(updates.getRoomNum());}
		if (updates.getTrainer() != null) {toUpdate.setTrainer(updates.getTrainer());}
		if (updates.getMaxClassNum() != null) {toUpdate.setLastName(updates.getLastName());}
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;		
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
		
	}

}
