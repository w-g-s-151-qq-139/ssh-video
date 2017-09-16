package com.zhiyou100.dao.model;

import java.util.Date;

public class Video {
    private Integer id;
    private Integer speakerid;
    private Integer courseid;

    private String videoTitle;


    private Integer videoLength;

    private String videoImageUrl;

    private String videoUrl;

    private String videoDescr;

    private Date insertTime;

    private Date updateTime;

    private Integer videoPlayTimes;
    
    private String videotime;
    private Course course;
    private Speaker speaker;
    
    

	public String getVideotime() {
		return videotime;
	}



	public void setVideotime(Integer length) {
		String h=length/60/60<10?"0"+length/60/60:length/60/60+"";
		String m=length/60%60<10?"0"+length/60%60:length/60%60+"";
		String s=length/60<10?"0"+length/60:length/60+"";
		this.videotime = h+":"+m+":"+s;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getVideoTitle() {
		return videoTitle;
	}



	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}



	public Integer getVideoLength() {
		return videoLength;
	}



	public void setVideoLength(Integer videoLength) {
		this.videoLength = videoLength;
		setVideotime(videoLength==null?0:videoLength);
	}



	public String getVideoImageUrl() {
		return videoImageUrl;
	}



	public void setVideoImageUrl(String videoImageUrl) {
		this.videoImageUrl = videoImageUrl;
	}



	public String getVideoUrl() {
		return videoUrl;
	}



	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}



	public String getVideoDescr() {
		return videoDescr;
	}



	public void setVideoDescr(String videoDescr) {
		this.videoDescr = videoDescr;
	}



	public Date getInsertTime() {
		return insertTime;
	}



	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public Integer getVideoPlayTimes() {
		return videoPlayTimes;
	}



	public void setVideoPlayTimes(Integer videoPlayTimes) {
		this.videoPlayTimes = videoPlayTimes;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	public Speaker getSpeaker() {
		return speaker;
	}



	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}



	public Integer getSpeakerid() {
		return speakerid;
	}



	public void setSpeakerid(Integer speakerid) {
		this.speakerid = speakerid;
	}



	public Integer getCourseid() {
		return courseid;
	}



	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}



	@Override
	public String toString() {
		return "Video [id=" + id + ", videoTitle=" + videoTitle + ", videoLength=" + videoLength + ", videoImageUrl="
				+ videoImageUrl + ", videoUrl=" + videoUrl + ", videoDescr=" + videoDescr + ", insertTime=" + insertTime
				+ ", updateTime=" + updateTime + ", videoPlayTimes=" + videoPlayTimes + ", videotime=" + videotime
				+ ", course=" + course + ", speaker=" + speaker + "]";
	}



	

	
    
}