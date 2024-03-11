package in.anand.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import in.anand.dao.UserDao;

@SpringBootTest
@ExtendWith(value = { MockitoExtension.class})
public class UserServiceTest {

	@MockBean
	private UserDao userDao;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	public void testGetUserName() {
		when(userDao.findName(101)).thenReturn("Ashok");
		
		String username = userService.getUserName(101);
		assertNotNull(username);
	}
}
