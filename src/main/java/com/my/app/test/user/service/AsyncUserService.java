package com.my.app.test.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.app.test.user.domain.User;
import com.my.app.test.user.mapper.UserMapper;

@Service
public class AsyncUserService {

	@Autowired
	private UserMapper userMapper;

	@Async
	@Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
	public List<User> getUsers() {
		List<User> users = userMapper.getUsers();
		return users;
	}

}
