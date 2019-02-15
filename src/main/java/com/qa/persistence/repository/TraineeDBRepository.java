package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllTrainee() {
		Query query = manager.createQuery("SELECT a FROM Account a");
		return util.getJSONForObject((Collection<Trainee>) query.getResultList());
	}

	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	public String getATrainee(Long studentNum) {
		return util.getJSONForObject(manager.find(Trainee.class, studentNum));
	}

	@Transactional(REQUIRED)
	public String deleteTrainee(Long studentNum) {
		if (manager.contains(manager.find(Trainee.class, studentNum))) {
			manager.remove(manager.find(Trainee.class, studentNum));
			return "{\"message\": \"trainee has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such trainee\"}";
	}

	@Transactional(REQUIRED)
	public String updateTrainee(Long studentNum, String trainee) {
		Trainee updates = util.getObjectForJSON(trainee, Trainee.class);
		if (manager.contains(manager.find(Trainee.class, studentNum))) {
			Trainee toUpdate = manager.find(Trainee.class, studentNum);
			if (updates.getStudentNum() != null) { 
				toUpdate.setStudentNum(updates.getStudentNum());}
			if (updates.getFirstName() != null) {
				toUpdate.setFirstName(updates.getFirstName());}
			if (updates.getLastName() != null) {
				toUpdate.setLastName(updates.getLastName());}
		return "{\"message\": \"trainee has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such trainee\"}";
		}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;

	}

}