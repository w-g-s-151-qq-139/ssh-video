package com.zhiyou100.service.impl.lecturer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.SpeakerDao;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.SearchSpeaker;
import com.zhiyou100.service.lecturer.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	SpeakerDao sd;
	@Override
	public List<Speaker> findall() {
		return sd.findall();
	}
	@Override
	public List<Speaker> findall(String searchspeakerName, String searchspeakerJob, int page) {
		SearchSpeaker speaker=new SearchSpeaker(searchspeakerName, searchspeakerJob, (page-1)*10);
		return sd.search(speaker);
	}
	@Override
	public int count(String searchspeakerName, String searchspeakerJob) {
		SearchSpeaker speaker=new SearchSpeaker(searchspeakerName, searchspeakerJob,0);
		return sd.count(speaker);
	}
	@Override
	public void delvideo(Integer id) {
		sd.del(id);
	}
	@Override
	public Speaker findone(Integer id) {
		// TODO Auto-generated method stub
		return sd.findone(id);
	}
	
	@Override
	public void updatespeaker(Speaker speaker) {
		// TODO Auto-generated method stub
	}
	@Override
	public void addspeaker(Speaker speaker) {
		sd.addspeaker(speaker);
	}

}
