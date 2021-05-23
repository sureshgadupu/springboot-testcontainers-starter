package com.fullstackdev.springboot.tcdemo.it;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.fullstackdev.springboot.tcdemo.entity.User;
import com.fullstackdev.springboot.tcdemo.entity.UserType;

public class UserControllerIT extends BaseIT {

	@Test
	@Sql({ "/DELETE_ALL.sql" })
	public void saveUser() {

		User user = new User();

		user.setFirstName("abc");
		user.setLastName("def");
		user.setEmail("adc@sdf.com");
		user.setDisabled(false);
		user.setSalary(1200d);
		user.setUserType(UserType.GOLD);
			
		ResponseEntity<User> response = testRestTemplate.postForEntity( "/users", user, User.class);

		User u = (User) response.getBody();

		
		assertNotNull(u.getId());
		assertEquals("abc", u.getFirstName());

	}

	@Test
	@Sql({ "/DELETE_ALL.sql", "/INSERT_USERS.sql" })
	public void testGetUserById() {
		long userId = 104;

		ResponseEntity<User> responseEntity = testRestTemplate.getForEntity("/users/{id}", User.class,
				userId);

		User u = (User) responseEntity.getBody();
	
		assertEquals(104, u.getId());

	}
	
	@Test
	@Sql({ "/DELETE_ALL.sql", "/INSERT_USERS.sql" })
	public void testFindByAllUsersSortByUsertype() {
		
		ResponseEntity<User[]> responseEntity = testRestTemplate.getForEntity("/users/getSortedUsers", User[].class);
		
		
		List<User> users = Arrays.asList(responseEntity.getBody());
		
		assertEquals(106, users.get(0).getId());
		assertEquals("NareshGoel", users.get(0).getFirstName());
		assertEquals("PLATINUM", users.get(0).getUserType().name());

	}

	
}
