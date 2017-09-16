package com.zhiyou100.service.user;

import java.util.List;

import com.zhiyou100.dao.model.User;

public interface UserService {

	List<User> login(User u);

	int register(User u);

	List<User> select(User u);

	void update(User u);

}
