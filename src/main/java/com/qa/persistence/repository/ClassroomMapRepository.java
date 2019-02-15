package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	Map<Long, Classroom> classroomMap = new HashMap<Long, Classroom>();

	public Map<Long, Classroom> getClassroomMap() {
		return classroomMap;
	}

	public void setClassroomMap(Map<Long, Classroom> classroomMap) {
		this.classroomMap = classroomMap;
	}

	private JSONUtil util = new JSONUtil();

	public String getAllClassroom() {
		return util.getJSONForObject(classroomMap.values());
	}

	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(aClassroom.getRoomNum(), aClassroom);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	public String deleteClassroom(Long roomNum) {
		if (classroomMap.get(roomNum) != null) {
			classroomMap.remove(roomNum);
			return "{\"message\": \"classroom has been sucessfully deleted\"}";
		}
		return "{\"message\": \"no such classroom\"}";
	}

	public String updateClassroom(Long roomNum, String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		if (classroomMap.get(roomNum) != null) {
			classroomMap.put(roomNum, aClassroom);
			return "{\"message\": \"classroom has been sucessfully updated\"}";
		}
		return "{\"message\": \"no such classroom\"}";
	}


	public String getAClassroom(Long roomNum) {
		return util.getJSONForObject(classroomMap.get(roomNum));
	}



}
