package com.zhiyou100.dao.warp;

import com.zhiyou100.dao.model.Video;

public class VideoWarp {

	private Video video;
	private String speakername;
	private String coursename;
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getSpeakername() {
		return speakername;
	}
	public void setSpeakername(String speakername) {
		this.speakername = speakername;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	@Override
	public String toString() {
		return "VideoWarp [video=" + video + ", speakername=" + speakername + ", coursename=" + coursename + "]";
	}
	
}
