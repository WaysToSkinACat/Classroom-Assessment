//package assessment.Classroom;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import com.qa.persistence.domain.Trainee;
//import com.qa.persistence.repository.TraineeDBRepository;
//import com.qa.util.JSONUtil;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TraineeDBRepositoryTest {
//	
//	@InjectMocks
//	private TraineeDBRepository repo;
//
//	@Mock
//	private EntityManager manager;
//	
//	@Mock
//	private Query query;
//
//	private JSONUtil util;
//	
//	private List<Trainee> trainees;
//	
//	private static final String MOCK_OBJECT = "{\"studentNum\":1,\"firstName\":\"train\",\"lastName\":\"jim\"}";
//	
//	private static final String MOCK_DATA_ARRAY = "[{\"studentNum\":1,\"firstName\":\"train\",\"lastName\":\"jim\"},"
//			+ "{\"studentNum\":2,\"firstName\":\"trains\",\"lastName\":\"jim\"}]";
//	
//	@Before
//	public void setup() {
//		
//		trainees = new ArrayList<Trainee>();
//		trainees.add(new Trainee(1L,"train", "jim"));
//		trainees.add(new Trainee(2L, "trains", "jim"));
//		
//		repo.setManager(manager);
//		util = new JSONUtil();
//		repo.setUtil(util);
//	}
//	
//	@Test
//	public void TestGetAllTrainees() {
//	Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//	Mockito.when(query.getResultList()).thenReturn(trainees);
//	assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainee());
//
//	}
//	
//	@Test
//
//	public void testGetATrainee() {
//		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainees.get(0));
//		assertEquals(MOCK_OBJECT, repo.getATrainee(1L));
//	}
//	
//	@Test
//	public void testCreateTrainee() {
//		String reply = repo.createTrainee(MOCK_OBJECT);
//		assertEquals("{\"message\": \"trainee has been sucessfully added\"}", reply);
//	}
//	
//	@Test
//	public void testDeleteTrainee() {
//		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
//		String reply = repo.deleteTrainee(1L);
//		assertEquals("{\"message\": \"trainee has been sucessfully deleted\"}", reply);
//	}
//	
//
//	@Test
//	public void testUpdateTraineePart1() {
//		String trainee = "{\"studentNum\":\"111111\"}";
//		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
//		Mockito.when(manager.find(Mockito.any(), Mockito.anyObject())).thenReturn(trainees.get(0));
//		assertEquals("{\"message\": \"trainee has been sucessfully updated\"}", repo.updateTrainee(1L, trainee));
//	}
//	
//
//	@Test
//	public void testUpdateTraineePart2() {
//		String trainee = "{\"Trainer\":\"Josh\",\"trainees\":\"Angry\"}";
//		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
//		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(trainees.get(0));
//		assertEquals("{\"message\": \"trainee has been sucessfully updated\"}", repo.updateTrainee(1L, trainee));
//	}
//	
//}
//
