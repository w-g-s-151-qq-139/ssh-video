package com.zhiyou100.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.AdminDao;
import com.zhiyou100.dao.dao.VideoDao;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	AdminDao ad;
	@Autowired
	VideoDao vm;
	@Override
	public List<Admin> login(Admin obj) {
		return ad.login(obj);
	}
	@Override
	public List<VideoWarp> show() {
		return null;
	}

}
