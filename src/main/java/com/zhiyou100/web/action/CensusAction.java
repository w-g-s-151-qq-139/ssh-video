package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.service.video.VideoService;

@Controller
@Scope("prototype")
public class CensusAction extends ActionSupport{

	@Autowired
	VideoService vs;
	public String show(){
		List<CourseWarp> census = vs.avgtimes();
		//System.out.println(census);
		String avgtimes = "";
		String coursename = "";
		for (CourseWarp c : census) {
			coursename += c.getCourseName() + ",";
			if (c.getAvgtimes() == null) {
				avgtimes += "0,";
			} else
				avgtimes += c.getAvgtimes() + ",";
		}
		ActionContext.getContext().put("coursename", coursename.substring(0, coursename.length()-1));
		ActionContext.getContext().put("avgtimes", avgtimes.substring(0, avgtimes.length()-1));
		return SUCCESS;
	}
}
