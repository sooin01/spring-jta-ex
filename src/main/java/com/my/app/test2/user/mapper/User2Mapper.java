package com.my.app.test2.user.mapper;

import java.util.List;

import com.my.app.test.user.domain.User;

public interface User2Mapper {

	List<User> getUsers();

	int insertUser(User user);

}
