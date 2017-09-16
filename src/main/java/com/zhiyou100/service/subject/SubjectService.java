package com.zhiyou100.service.subject;

import java.util.List;

import com.zhiyou100.dao.model.Subject;

public interface SubjectService {


	List<Subject> findall();

	Subject findone(Integer subjectId);

}
