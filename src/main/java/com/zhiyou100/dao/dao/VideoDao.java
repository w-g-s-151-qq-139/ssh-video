package com.zhiyou100.dao.dao;

import java.util.List;

import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.SearchVideo;
import com.zhiyou100.dao.warp.VideoWarp;

public interface VideoDao {

	List<Video> findall(SearchVideo sv);

	int count(String searchvideoTitle, String searchcourseId, String searchspeakerId);

	Video findone(Integer id);

	void delvideo(Integer id);

	int addvideo(Video video);

	void batch(String id);

	List<Object[]> avgtimes();

	List<Video> findcourseid(Integer id);


}
