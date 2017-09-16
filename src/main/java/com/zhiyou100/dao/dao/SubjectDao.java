package com.zhiyou100.dao.dao;

import java.util.List;

import com.zhiyou100.dao.model.Subject;

public interface SubjectDao {

	List<Subject> findall();

	Subject findone(Integer subjectId);


}
