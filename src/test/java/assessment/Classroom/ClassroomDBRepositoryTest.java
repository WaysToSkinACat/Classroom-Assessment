package assessment.Classroom;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
	
	
	
	private static final String MOCK_OBJECT = "{\"roomNum\":\"1\",\"trainer\":\"Smith\",\"maxClassNum\":\"12\",\"trainees\":\"jim\"}";
	
	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"Ella\",\"lastName\":\"Smith\",\"accountNumber\":\"123456\"},"
			+ "{\"firstName\":\"Tony\",\"lastName\":\"Dead\",\"accountNumber\":\"654321\"}]";
	
	
}
