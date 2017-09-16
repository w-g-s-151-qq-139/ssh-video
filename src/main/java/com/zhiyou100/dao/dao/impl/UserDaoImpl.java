package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.UserDao;
import com.zhiyou100.dao.model.User;


public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public List<User> select(User u) {
		System.out.println(u);
		DetachedCriteria dc=DetachedCriteria.forClass(User.class);
		if(u.getEmail()!=null){
			dc.add(Restrictions.eq("email", u.getEmail()));	
		}
		if(u.getPassword()!=null)
			dc.add(Restrictions.eq("password", u.getPassword()));
		return  (List<User>) getHibernateTemplate().findByCriteria(dc);
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(u);
	}

}
