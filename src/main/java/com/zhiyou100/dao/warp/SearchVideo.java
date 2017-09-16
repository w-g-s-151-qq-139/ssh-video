package com.zhiyou100.dao.warp;

public class SearchVideo {

	private String title;
	private String speakerid;
	private String courseid;
	private int currentpage;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSpeakerid() {
		return speakerid;
	}
	public void setSpeakerid(String speakerid) {
		this.speakerid = speakerid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	@Override
	public String toString() {
		return "SearchVideo [title=" + title + ", speakerid=" + speakerid + ", courseid=" + courseid + ", currentpage="
				+ currentpage + "]";
	}
	
}
