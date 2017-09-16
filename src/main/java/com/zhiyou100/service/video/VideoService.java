package com.zhiyou100.service.video;

import java.util.List;

import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.VideoWarp;

public interface VideoService {

	void delvideo(Integer id);
	int addvideo(Video video);
	int updatevideo(Video video);
	Video findone(Integer id);
	List<Video> findterm(String searchvideoTitle, String searchcourseId, String searchspeakerId,Integer currentpage);
	void batch(String id);
	List<CourseWarp> avgtimes();
	int count(String searchvideoTitle, String searchcourseId, String searchspeakerId);
	List<Video> findcourseid(Integer id);
}
