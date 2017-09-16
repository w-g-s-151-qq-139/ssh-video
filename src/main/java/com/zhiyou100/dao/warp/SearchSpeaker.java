package com.zhiyou100.dao.warp;

public class SearchSpeaker {

	private String searchspeakerName;
	private String searchspeakerJob;
	private int page;
	
	public SearchSpeaker(String searchspeakerName, String searchspeakerJob, int page) {
		super();
		this.searchspeakerName = searchspeakerName;
		this.searchspeakerJob = searchspeakerJob;
		this.page = page;
	}
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
