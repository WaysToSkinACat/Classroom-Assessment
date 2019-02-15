package com.qa.persistence.repository;

import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class ClassroomDBRepository implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllClassroom() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Classroom>) query.getResultList());
	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		manager.persist(aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	public String getAClassroom(Long roomNum) {
		return util.getJSONForObject(manager.find(Classroom.class, roomNum));
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long roomNum) {
		if (manager.contains(manager.find(Classroom.class, roomNum))) {
			manager.remove(manager.find(Classroom.class, roomNum));
			return "{\"message\": \"classroom has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such account\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long roomNum, String classroom) {
		Classroom updates = util.getObjectForJSON(classroom, Classroom.class);
		Classroom toUpdate = manager.find(Classroom.class, roomNum);
		if (manager.contains(manager.find(Classroom.class, roomNum))) {
			if (updates.getRoomNum() != null) {
				toUpdate.setRoomNum(updates.getRoomNum());
			}
			if (updates.getTrainer() != null) {
				toUpdate.setTrainer(updates.getTrainer());
			}
			// if (updates.getMaxClassNum() != null)
			// {toUpdate.setMaxClassNum(updates.getMaxClassNum());}
			if (updates.getTrainees() != null) {
				toUpdate.setTrainees(updates.getTrainees());
			}
			return "{\"message\": \"classroom has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such classroom\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;

	}

}
