package com.zhiyou100.service.lecturer;

import java.util.List;

import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;

public interface LecturerService {

	List<Speaker> findall();
	int count(String searchspeakerName, String searchspeakerJob);
	List<Speaker> findall(String searchspeakerName, String searchspeakerJob, int page);
	void delvideo(Integer id);
	Speaker findone(Integer id);
	void updatespeaker(Speaker speaker);
	void addspeaker(Speaker speaker);
}
