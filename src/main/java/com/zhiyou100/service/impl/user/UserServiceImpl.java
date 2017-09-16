package com.zhiyou100.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.UserDao;
import com.zhiyou100.dao.model.User;
import com.zhiyou100.service.user.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao um;
	@Override
	public List<User> login(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int register(User u) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<User> select(User u) {
		return um.select(u);
	}
	@Override
	public void update(User u) {
		um.update(u);
	}

}
