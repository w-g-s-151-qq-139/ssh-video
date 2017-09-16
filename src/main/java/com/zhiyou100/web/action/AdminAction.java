package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.dao.AdminDao;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.utils.MD5Util;
import com.zhiyou100.service.LoginService;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.service.video.VideoService;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{

	@Autowired
	LoginService ls;
	@Autowired
	LecturerService lts;
	@Autowired
	CourseService cs;
	private Admin admin=new Admin();

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		admin.setLoginPwd(MD5Util.MD5EncodeUtf8(admin.getLoginPwd()));
//		 
//		
		List<Admin> adminlist = ls.login(admin);
		ActionContext context = ActionContext.getContext();
		if (adminlist.size() != 0) {
			context.getSession().put("admin", adminlist.get(0));
			context.getSession().put("speakerlist", lts.findall());
			context.getSession().put("courselist", cs.findall());
			return "success";
		}else{
			
			context.put("loginName", admin.getLoginName());
			context.put("error", "’À∫≈∫Õ√‹¬Î≤ª∆•≈‰");
			return "false";
		}
	}
}
