package com.zhiyou100.service.impl.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.SubjectDao;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.service.subject.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao sm;
	@Override
	public List<Subject> findall() {
		// TODO Auto-generated method stub
		return sm.findall();
	}
	@Override
	public Subject findone(Integer subjectId) {
		// TODO Auto-generated method stub
		return sm.findone(subjectId);
	}

}
