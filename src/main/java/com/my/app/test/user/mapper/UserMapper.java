package com.my.app.test.user.mapper;

import java.util.List;

import com.my.app.test.user.domain.User;

public interface UserMapper {

	List<User> getUsers();

	int insertUser(User user);

}
