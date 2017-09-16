package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.SubjectDao;
import com.zhiyou100.dao.model.Subject;


public class SubjectDaoImpl extends HibernateDaoSupport implements SubjectDao {

	@Override
	public List<Subject> findall() {
		// TODO Auto-generated method stub
		return (List<Subject>) getHibernateTemplate().find("from Subject");
	}

	@Override
	public Subject findone(Integer subjectId) {
		// TODO Auto-generated method stub
		return (Subject) getHibernateTemplate().find("from Subject where id=?",subjectId).get(0);
	}


}
