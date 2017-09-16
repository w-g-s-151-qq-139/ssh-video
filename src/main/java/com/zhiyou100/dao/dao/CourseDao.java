package com.zhiyou100.dao.dao;

import java.util.List;

import com.zhiyou100.dao.model.Course;

public interface CourseDao {

	List<Course> findall();

	Course findone(Integer id);

	List<Course> show(int page);

	int count();

	void addcourse(Course course);

	void delcourse(Integer id);

	List<Course> courseshow(Integer subjectId);

}
