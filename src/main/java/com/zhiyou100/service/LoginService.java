package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.warp.VideoWarp;

public interface LoginService {

	List<Admin> login(Admin obj);
	List<VideoWarp> show();
}
