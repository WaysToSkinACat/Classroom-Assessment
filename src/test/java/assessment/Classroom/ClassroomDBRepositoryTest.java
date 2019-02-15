package assessment.Classroom;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.MockitoConfigurationException;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassroomDBRepositoryTest {
	
	@InjectMocks
	private ClassroomDBRepository repo;

	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;

	private JSONUtil util;
	
	private List<Classroom> classrooms;
	
	private static final String MOCK_OBJECT = "{\"roomNum\":1,\"trainer\":\"train\",\"maxClassNum\":12,\"trainees\":\"jim\"}";
	
	private static final String MOCK_DATA_ARRAY = "[{\"roomNum\":1,\"trainer\":\"train\",\"maxClassNum\":30,\"trainees\":\"jim\"},"
			+ "{\"roomNum\":2,\"trainer\":\"trains\",\"maxClassNum\":10,\"trainees\":\"jim\"}]";
	
	@Before
	public void setup() {
		
		classrooms = new ArrayList<Classroom>();
		classrooms.add(new Classroom(1L,"train", 30, "jim"));
		classrooms.add(new Classroom(2L, "trains", 10, "jim"));
		
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void TestGetAllClassrooms() {
	Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
	Mockito.when(query.getResultList()).thenReturn(classrooms);
	assertEquals(MOCK_DATA_ARRAY, repo.getAllClassroom());

	}
	
	@Test
	@Ignore
	public void testGetAClassroom() {
		Classroom clazz;
		Mockito.when(manager.find(Mockito.anyObject(), Mockito.anyLong())).thenReturn(classrooms.get(0));
		assertEquals(MOCK_OBJECT, repo.getAClassroom(1L));
	}
	
	@Test
	public void testCreateAccount() {
		String reply = repo.createClassroom(MOCK_OBJECT);
		assertEquals("{\"message\": \"account has been sucessfully added\"}", reply);
	}
	
	@Test
	public void testDeleteAccount() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		String reply = repo.deleteClassroom(1L);
		assertEquals("{\"message\": \"account has been sucessfully deleted\"}", reply);
	}
	
	@Ignore
	@Test
	public void testUpdateAccountPart1() {
		String account = "{\"roomNum\":\"111111\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(classrooms.get(0));
		assertEquals("{\"message\": \"account has been sucessfully updated\"}", repo.updateClassroom(1L, account));
	}
	
	@Ignore
	@Test
	public void testUpdateAccountPart2() {
		String account = "{\"Trainer\":\"Josh\",\"trainees\":\"Angry\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(classrooms.get(0));
		assertEquals("{\"message\": \"account has been sucessfully updated\"}", repo.updateClassroom(1L, account));
	}
	
}
