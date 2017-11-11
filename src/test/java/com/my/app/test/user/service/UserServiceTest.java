package com.my.app.test.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.my.app.test.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { //
		"classpath:spring/root-context.xml", //
		"classpath:spring/atomikos-context.xml", // atomikos
		// "classpath:spring/bitronix-context.xml", // bitronix
})
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testgetUsers() {
		for (User user : userService.getUsers()) {
			System.out.println(user);
		}
	}

}
