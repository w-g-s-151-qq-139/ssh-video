package com.zhiyou100.dao.warp;

public class CourseWarp {

	private Integer id;
	private String courseName;
	private Integer avgtimes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getAvgtimes() {
		return avgtimes;
	}
	public void setAvgtimes(Integer avgtimes) {
		this.avgtimes = avgtimes;
	}
	@Override
	public String toString() {
		return "CourseWarp [id=" + id + ", courseName=" + courseName + ", avgtimes=" + avgtimes + "]";
	}
	
	
}
