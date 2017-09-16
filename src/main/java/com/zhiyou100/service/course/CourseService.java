package com.zhiyou100.service.course;

import java.util.List;

import com.zhiyou100.dao.model.Course;

public interface CourseService {

	List<Course> findall();

	int count();

	List<Course> findall(int page);

	void delcourse(Integer id);

	Course findone(Integer id);

	void updatespeaker(Course course);

	void addspeaker(Course course);
	List<Course> courseshow(Integer subjectId);
}
