package com.my.app.test.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.app.test.user.domain.User;
import com.my.app.test.user.mapper.UserMapper;
import com.my.app.test2.user.mapper.User2Mapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired(required = false)
	private User2Mapper user2Mapper;

	@Autowired
	private AsyncUserService asyncUserService;

	@Transactional(readOnly = true)
	public List<User> getUsers() {
		User user = new User();
		user.setUserId("test222");
		List<User> users = userMapper.getUsers(user);

		if (user2Mapper != null) {
			List<User> users2 = user2Mapper.getUsers();
			users.addAll(users2);
		}

		asyncUserService.getUsers();

		return users;
	}

	@Transactional
	public int insertUser() {
		int count = 0;
		count += userMapper.insertUser(new User("test1", "테스트1"));
		count += user2Mapper.insertUser(new User("test2", "테스트2"));
		return count;
	}

}
