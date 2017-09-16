package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.dao.utils.Page;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.subject.SubjectService;

@Controller
@Scope("prototype")
public class CourseAction extends ActionSupport implements ModelDriven<Course>{

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	
	private Course course=new Course();
	private Integer page=1;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	/*
	 * ÏÔÊ¾
	 */
	public String show(){
		List<Course> findall = cs.findall(page);
		Page<Course> Pageutil=new Page<>();
		int count=cs.count();
		Pageutil.setPage(page);
		Pageutil.setSize(10);
		Pageutil.setRows(findall);
		Pageutil.setTotal(count); 
		ActionContext.getContext().put("Pageutil", Pageutil);
		return SUCCESS;
	}
	/*
	 * ÐÞ¸Ä
	 */
	public String alt(){
		Course editcourse=new Course();
		List<Subject> subject=ss.findall();
		if(course.getId()!=null){
			editcourse=cs.findone(course.getId());
		}
		ActionContext.getContext().put("editcourse", editcourse);
		ActionContext.getContext().put("subject", subject);
		return SUCCESS;
	}
	/*
	 * Ìí¼Ó
	 */
	public String add(){
		
		course.setSubject(course.getSubjectId()==0?null:ss.findone(course.getSubjectId()));
		cs.addspeaker(course);
		return SUCCESS;
	}
	/*
	 * É¾³ý
	 */
	public String del(){
		cs.delcourse(course.getId());
		return SUCCESS;
	}

	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}
}
