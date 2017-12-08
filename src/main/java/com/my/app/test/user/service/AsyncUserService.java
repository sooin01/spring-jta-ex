package com.my.app.test.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, Object> parameterMap = new HashMap<>();
		parameterMap.put("userId", "test222");
		List<User> users = userMapper.getUsers(parameterMap);
		return users;
	}

}
