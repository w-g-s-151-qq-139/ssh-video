package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhiyou100.dao.model.Course;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Subject;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.service.subject.SubjectService;
import com.zhiyou100.service.video.VideoService;

@Controller
@Scope("prototype")
public class ShowVideoAction extends ActionSupport {

	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	@Autowired
	VideoService vs;
	@Autowired
	LecturerService ls;
	
	private Integer subjectId;
	private Integer videoId;
	
	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	/*
	 * 课程信息
	 */
	public String courseindex(){
		ActionContext context = ActionContext.getContext();
		List<Course> courses=cs.courseshow(subjectId);
		Subject subject=ss.findone(subjectId);
		context.put("courses", courses);
		context.put("subjectId", subjectId);
		context.put("subject", subject);
		return SUCCESS;
	}
	/*
	 * 视频信息
	 */
	public String index(){
		ActionContext context = ActionContext.getContext();
		Subject subject=ss.findone(subjectId);
		Video video=vs.findone(videoId);
		context.put("subject", subject);
		context.put("videoId", videoId);
		context.put("video", video);
		return "index";
	}
	/*
	 * 详细视频信息
	 */
	public String data(){
		ActionContext context = ActionContext.getContext();
		Video video=vs.findone(videoId);
		context.put("video", video);
		context.put("speaker", video.getSpeaker());
		context.put("course", video.getCourse());
		List<Video> videolist=vs.findcourseid(video.getCourse().getId());
		
		List<Speaker> sp=ls.findall();
		context.put("speakerlist", sp);
		
		context.put("videolist", videolist);
		return "content";
	}
	/*
	 * 视频次数
	 */
	public void state(){
		Video video=vs.findone(videoId);
		video.setVideoPlayTimes(video.getVideoPlayTimes()==null?1:video.getVideoPlayTimes()+1);
		vs.updatevideo(video);
	}
}
