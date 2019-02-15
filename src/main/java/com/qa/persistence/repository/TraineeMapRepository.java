package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Alternative
public class TraineeMapRepository implements TraineeRepository {
	
		Map<Long, Trainee> traineeMap = new HashMap<Long, Trainee>();

		public Map<Long, Trainee> getTraineeMap() {
			return traineeMap;
		}

		public void setTraineeMap(Map<Long, Trainee> traineeMap) {
			this.traineeMap = traineeMap;
		}

		private JSONUtil util = new JSONUtil();

		public String getAllTrainee() {
			return util.getJSONForObject(traineeMap.values());
		}

		public String createTrainee(String trainee) {
			Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
			traineeMap.put(aTrainee.getStudentNum(), aTrainee);
			return "{\"message\": \"trainee has been sucessfully added\"}";
		}

		public String deleteTrainee(Long studentNum) {
			if (traineeMap.get(studentNum) != null) {
				traineeMap.remove(studentNum);
				return "{\"message\": \"trainee has been sucessfully deleted\"}";
			}
			return "{\"message\": \"no such trainee\"}";
		}

		public String updateTrainee(Long studentNum, String trainee) {
			Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
			if (traineeMap.get(studentNum) != null) {
				traineeMap.put(studentNum, aTrainee);
				return "{\"message\": \"trainee has been sucessfully updated\"}";
			}
			return "{\"message\": \"no such trainee\"}";
		}


		public String getATrainee(Long studentNum) {
			return util.getJSONForObject(traineeMap.get(studentNum));
		}



	}
