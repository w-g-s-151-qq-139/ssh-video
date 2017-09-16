package com.zhiyou100.dao.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Course {
    private Integer id;

    private String courseName;
    private Integer subjectId;

    private String courseDescr;

    private Date insertTime;

    private Date updateTime;

    private Subject subject;
    private Set<Video> videolist;

    

	public Set<Video> getVideolist() {
		return videolist;
	}

	public void setVideolist(Set<Video> videolist) {
		this.videolist = videolist;
	}

	

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

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
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseDescr() {
        return courseDescr;
    }

    public void setCourseDescr(String courseDescr) {
        this.courseDescr = courseDescr == null ? null : courseDescr.trim();
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

    

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", subjectId=" + subjectId + ", courseDescr="
				+ courseDescr + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", subject=" + subject
				+ "]";
	}

	
    
}