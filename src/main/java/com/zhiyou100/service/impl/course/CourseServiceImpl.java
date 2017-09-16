package com.zhiyou100.service.impl.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.CourseDao;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.service.course.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDao cm;
	
	@Override
	public List<Course> findall() {
		// TODO Auto-generated method stub
		
		return cm.findall();
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return cm.count();
	}
	@Override
	public List<Course> findall(int page) {
		// TODO Auto-generated method stub
		
		return cm.show(page);
	}
	@Override
	public void delcourse(Integer id) {
		cm.delcourse(id);
	}
	@Override
	public Course findone(Integer id) {
		// TODO Auto-generated method stub
		return cm.findone(id);
	}
	@Override
	public void updatespeaker(Course course) {
		// TODO Auto-generated method stub
	}
	@Override
	public void addspeaker(Course course) {
		cm.addcourse(course);
	}
	@Override
	public List<Course> courseshow(Integer subjectId) {
		
		return cm.courseshow(subjectId);
	}

}
