package com.zhiyou100.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.utils.Page;
import com.zhiyou100.service.lecturer.LecturerService;

@Controller
@Scope("prototype")
public class SpeakerAction extends ActionSupport implements ModelDriven<Speaker>{

	@Autowired
	LecturerService ls;
	
	private String searchspeakerName="";
	private String searchspeakerJob="";
	private Integer page=1;
	private Speaker speaker=new Speaker();
	
	public String getSearchspeakerName() {
		return searchspeakerName;
	}
	public void setSearchspeakerName(String searchspeakerName) {
		this.searchspeakerName = searchspeakerName;
	}
	public String getSearchspeakerJob() {
		return searchspeakerJob;
	}
	public void setSearchspeakerJob(String searchspeakerJob) {
		this.searchspeakerJob = searchspeakerJob;
	}
	/*
	 * 查询显示
	 */
	public String search(){
		List<Speaker> speakerlist = null; 
		Page<Speaker> Pageutil=new Page<>();
		Pageutil.setPage(page);
		speakerlist=ls.findall(searchspeakerName, searchspeakerJob, page);
		int count=ls.count(searchspeakerName, searchspeakerJob);
		Pageutil.setSize(10);
		Pageutil.setRows(speakerlist);
		Pageutil.setTotal(count); 
		ActionContext.getContext().put("Pageutil", Pageutil);
		return SUCCESS;
	}
	/*
	 * 修改
	 */
	public String alt(){
		Speaker editspeaker=new Speaker();
		if(speaker.getId()!=null){
			editspeaker=ls.findone(speaker.getId());
		}
		ActionContext.getContext().put("editspeaker", editspeaker);
		return SUCCESS;
	}
	/*
	 * 添加
	 */
	public String add(){
		ls.addspeaker(speaker);
		return SUCCESS;
	}
	/*
	 * 删除
	 */
	public String del(){
		ls.delvideo(speaker.getId());
		return SUCCESS;
	}
	@Override
	public Speaker getModel() {
		// TODO Auto-generated method stub
		return speaker;
	}
}
