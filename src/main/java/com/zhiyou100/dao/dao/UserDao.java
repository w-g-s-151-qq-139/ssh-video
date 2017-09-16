package com.zhiyou100.dao.dao;

import java.util.List;

import com.zhiyou100.dao.model.User;

public interface UserDao {

	List<User> select(User u);

	void update(User u);

}
