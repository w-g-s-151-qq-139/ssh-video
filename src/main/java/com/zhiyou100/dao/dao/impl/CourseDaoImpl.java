package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.CourseDao;
import com.zhiyou100.dao.model.Course;


public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public List<Course> findall() {
		
		return (List<Course>) getHibernateTemplate().find("select distinct c from Course c left join fetch c.subject");
	}

	@Override
	public Course findone(Integer id) {
		// TODO Auto-generated method stub
		return (Course) getHibernateTemplate().find("from Course where id=?", id).get(0);
	}

	@Override
	public List<Course> show(int page) {
		
		return (List<Course>) getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Course.class),(page-1)*10,10);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(Course.class)).size();
	}

	@Override
	public void addcourse(Course course) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(course);
	}

	@Override
	public void delcourse(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from Course where id= ?";   
		getSessionFactory().getCurrentSession().createSQLQuery(sql).setInteger(0, id).executeUpdate();
	}

	@Override
	public List<Course> courseshow(Integer subjectId) {
		
		return (List<Course>) getHibernateTemplate().find("from Course c left join fetch c.subject s where s.id=?", subjectId);
	}

}
