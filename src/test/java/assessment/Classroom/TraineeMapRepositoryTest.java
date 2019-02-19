package assessment.Classroom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.repository.TraineeMapRepository;
import com.qa.util.JSONUtil;

public class TraineeMapRepositoryTest {

	TraineeMapRepository repo;
	private JSONUtil util;

	@Before
	public void setup() {
		util = new JSONUtil();
		repo = new TraineeMapRepository();
		repo.createTrainee(
				 "{\"studentNum\":1,\"firstName\":\"train\",\"lastName\":\"train\"}");
		repo.createTrainee(
				 "{\"studentNum\":2,\"firstName\":\"train\",\"lastName\":\"train\"}");
		repo.createTrainee(
				  "{\"studentNum\":3,\"firstName\":\"train\",\"lastName\":\"train\"}");
		repo.createTrainee(
				  "{\"studentNum\":4,\"firstName\":\"train\",\"lastName\":\"train\"}");
	}

	@Test
	public void addTraineeTest() {
		assertNotNull(repo.getTraineeMap().get(1L));
	}

	@Test
	public void add2TraineesTest() {
		assertNotNull(repo.getTraineeMap().get(2L));
	}

	@Test
	public void removeTraineeTest() {
		repo.deleteTrainee(1L);
		assertNull(repo.getTraineeMap().get(1L));
	}

	@Test
	public void remove2TraineesTest() {
		repo.deleteTrainee(1L);
		repo.deleteTrainee(2L);
		assertNull(repo.getTraineeMap().get(2L));
	}

	@Test
	public void remove2TraineeTestAnd1ThatDoesntExist() {
		repo.deleteTrainee(1L);
		repo.deleteTrainee(2L);
		assertEquals("{\"message\": \"no such trainee\"}", repo.deleteTrainee(2L));
	}

	@Test
	public void traineeUpdateTest() {
		repo.updateTrainee(1L, "{\"firstName\":\"Josh\"}");
		assertEquals("Josh", repo.getTraineeMap().get(1L).getFirstName());
	}

	@Test
	public void jsonStringToTraineeConversionTest() {
		assertEquals(repo.getTraineeMap().get(1L).getStudentNum(),
				util.getObjectForJSON("{\"studentNum\":1,\"firstName\":\"train\",\"lastName\":\"train\"}", Trainee.class).getStudentNum());
	}

	@Test
	public void classroomConversionToJSONTest() {
		assertEquals("{\"studentNum\":1,\"firstName\":\"train\",\"lastName\":\"train\"}",
				util.getJSONForObject(repo.getTraineeMap().get(1L)));
	}


}
