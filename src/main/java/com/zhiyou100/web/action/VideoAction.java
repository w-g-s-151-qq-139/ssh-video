package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.utils.Page;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.course.CourseService;
import com.zhiyou100.service.lecturer.LecturerService;
import com.zhiyou100.service.video.VideoService;

@Controller
@Scope("prototype")
public class VideoAction extends ActionSupport implements ModelDriven<Video> {

	@Autowired
	VideoService vs;
	@Autowired
	LecturerService lts;
	@Autowired
	CourseService cs;
	private String searchvideoTitle = "";
	private String searchcourseId = "0";
	private String searchspeakerId = "0";
	private Integer page = 0;
	private Integer vid = 0;
	private String idarr;

	public String getIdarr() {
		return idarr;
	}

	public void setIdarr(String idarr) {
		this.idarr = idarr;
	}

	private Video video = new Video();

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSearchvideoTitle() {
		return searchvideoTitle;
	}

	public void setSearchvideoTitle(String searchvideoTitle) {
		this.searchvideoTitle = searchvideoTitle;
	}

	public String getSearchcourseId() {
		return searchcourseId;
	}

	public void setSearchcourseId(String searchcourseId) {
		this.searchcourseId = searchcourseId;
	}

	public String getSearchspeakerId() {
		return searchspeakerId;
	}

	public void setSearchspeakerId(String searchspeakerId) {
		this.searchspeakerId = searchspeakerId;
	}

	/*
	 * 查找
	 */
	public String search() {
		List<Video> videolist = null;
		Page<Video> Pageutil = new Page<>();
		Pageutil.setPage(page == 0 ? 1 : page);
		videolist = vs.findterm(searchvideoTitle, searchcourseId, searchspeakerId, Pageutil.getPage());
		int count = vs.count(searchvideoTitle, searchcourseId, searchspeakerId);
		Pageutil.setSize(10);
		Pageutil.setRows(videolist);
		Pageutil.setTotal(count);
		ActionContext.getContext().put("Pageutil", Pageutil);
		return "success";
	}

	/*
	 * 修改
	 */
	public String altvideo() {
		Video editvideo = new Video();
		if (vid != 0) {
			editvideo = vs.findone(vid);

		}
		ActionContext.getContext().put("editvideo", editvideo);
		return SUCCESS;
	}

	/*
	 * 删除
	 */
	public String delvideo() {
		vs.delvideo(vid);
		return SUCCESS;
	}

	/*
	 * 保存
	 */
	public String addvideo() {
		video.setSpeaker(video.getSpeakerid()==0?null:lts.findone(video.getSpeakerid()));
//
		video.setCourse(video.getCourseid()==0?null:cs.findone(video.getCourseid()));
		vs.addvideo(video);
		return SUCCESS;
	}

	/*
	 * 批量删除
	 */
	public String batchvideo() {
		System.out.println(idarr);
		vs.batch(idarr);
		return SUCCESS;
	}

	@Override
	public Video getModel() {
		// TODO Auto-generated method stub
		return video;
	}
}
