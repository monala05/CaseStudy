package org.perscholas.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.perscholas.casestudy.config.WebAppConfig;
import org.perscholas.casestudy.models.User;
import org.perscholas.casestudy.models.UserLogin;
import org.perscholas.casestudy.services.UserLoginService;
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
class UserLoginIT {
	
	UserLoginService userLoginService;
	
	@Autowired
	public UserLoginIT(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	@Test
	@Transactional
	public void testPersist() {
		UserLogin login = new UserLogin();
		login.setPassword("Hello");
		userLoginService.save(login);
	}

}
