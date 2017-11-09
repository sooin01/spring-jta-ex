package com.my.app.test.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.app.test.user.domain.User;
import com.my.app.test.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping(value = "/users")
	public List<User> insertUser() {
		userService.insertUser();
		return getUsers();
	}

}
