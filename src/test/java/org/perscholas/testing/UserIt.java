package org.perscholas.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.perscholas.casestudy.config.WebAppConfig;
import org.perscholas.casestudy.models.User;
import org.perscholas.casestudy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserIt {

	UserService userService;
	
	@Autowired
	public UserIt(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	@Transactional
	public void testPersist() {
		User user = new User();
		user.setName("Alan");
		userService.save(user);
	}
	
	@Test
	@Transactional
	public void testFindByEmail() {
		User user = new User();
		user.setEmail("email");
		userService.save(user);
		User found = userService.findUserByEmail("email");
		System.out.println(found.getEmail());
		assertEquals(user, found);
	}
	
	@Test
	@Transactional
	public void testFindById() {
		User user = new User();
		user.setEmail("jhon");
		userService.save(user);
		int id = user.getId();
		User found = userService.findUserById(id);
		assertEquals(user, found);
		}
	
	@Test
	@Transactional
	public void testFindAll() {
		User user1 = new User();
		user1.setEmail("Alans");
		userService.save(user1);
		
		User user2 = new User();
		user2.setEmail("second");
		userService.save(user2);
		
		User user3 = new User();
		user3.setEmail("Third");
		userService.save(user3);
		
		List<User> users = userService.findAll();
		
		User found1 = userService.findUserByEmail("Alans");
		User found2 = userService.findUserByEmail("Third");
		
		assertEquals(users.get(2), found2);
	}
	
}
