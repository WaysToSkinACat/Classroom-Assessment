package assessment.Classroom;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomMapRepository;
import com.qa.util.JSONUtil;

public class ClassroomMapRepositoryTest {

	ClassroomMapRepository repo;
	private JSONUtil util;

	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new ClassroomMapRepository();
		repo.createClassroom(
				 "{\"roomNum\":1,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}");
		repo.createClassroom(
				 "{\"roomNum\":2,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}");
		repo.createClassroom(
				  "{\"roomNum\":3,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}");
		repo.createClassroom(
				  "{\"roomNum\":4,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}");
	}

	@Test
	public void addClassroomTest() {
		assertNotNull(repo.getClassroomMap().get(1L));
	}

	@Test
	public void add2ClassroomsTest() {
		assertNotNull(repo.getClassroomMap().get(2L));
	}

	@Test
	public void removeClassroomTest() {
		repo.deleteClassroom(1L);
		assertNull(repo.getClassroomMap().get(1L));
	}

	@Test
	public void remove2ClassroomsTest() {
		repo.deleteClassroom(1L);
		repo.deleteClassroom(2L);
		assertNull(repo.getClassroomMap().get(2L));
	}

	@Test
	public void remove2ClassroomTestAnd1ThatDoesntExist() {
		repo.deleteClassroom(1L);
		repo.deleteClassroom(2L);
		assertEquals("{\"message\": \"no such classroom\"}", repo.deleteClassroom(2L));
	}

	@Test
	public void classroomUpdateTest() {
		repo.updateClassroom(1L, "{\"trainer\":\"Josh\"}");
		assertEquals("Josh", repo.getClassroomMap().get(1L).getTrainer());
	}

	@Test
	public void jsonStringToClassroomConversionTest() {
		assertEquals(repo.getClassroomMap().get(1L).getRoomNum(),
				util.getObjectForJSON(
						  "{\"roomNum\":1,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}",
						Classroom.class).getRoomNum());
	}

	@Test
	public void classroomConversionToJSONTest() {
		assertEquals("{\"roomNum\":1,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}",
				util.getJSONForObject(repo.getClassroomMap().get(1L)));
	}


}
