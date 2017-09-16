package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.AdminDao;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.warp.SearchVideo;


public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Override
	public List<Admin> login(Admin obj) {
		// TODO Auto-generated method stub
		return (List<Admin>) getHibernateTemplate().find("from Admin where loginName = ? and loginPwd = ?", obj.getLoginName(),obj.getLoginPwd());
	}

}
