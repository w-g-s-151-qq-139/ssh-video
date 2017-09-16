        package com.zhiyou100.dao.model;

import java.util.Date;
import java.util.Set;

public class Speaker {
    private Integer id;

    private String speakerName;

    private String speakerJob;

    private String speakerHeadUrl;

    private String speakerDescr;

    private Date insertTime;

    private Date updateTime;
    private Set<Video> videolist;

    public Set<Video> getVideolist() {
		return videolist;
	}

	public void setVideolist(Set<Video> videolist) {
		this.videolist = videolist;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName == null ? null : speakerName.trim();
    }

    public String getSpeakerJob() {
        return speakerJob;
    }

    public void setSpeakerJob(String speakerJob) {
        this.speakerJob = speakerJob == null ? null : speakerJob.trim();
    }

    public String getSpeakerHeadUrl() {
        return speakerHeadUrl;
    }

    public void setSpeakerHeadUrl(String speakerHeadUrl) {
        this.speakerHeadUrl = speakerHeadUrl == null ? null : speakerHeadUrl.trim();
    }

    public String getSpeakerDescr() {
        return speakerDescr;
    }

    public void setSpeakerDescr(String speakerDescr) {
        this.speakerDescr = speakerDescr == null ? null : speakerDescr.trim();
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

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speakerName=" + speakerName + ", speakerJob=" + speakerJob + ", speakerHeadUrl="
				+ speakerHeadUrl + ", speakerDescr=" + speakerDescr + ", insertTime=" + insertTime + ", updateTime="
				+ updateTime + "]";
	}
    
}