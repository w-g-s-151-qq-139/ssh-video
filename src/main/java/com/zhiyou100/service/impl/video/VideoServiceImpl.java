package com.zhiyou100.service.impl.video;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.dao.VideoDao;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.SearchVideo;
import com.zhiyou100.dao.warp.VideoWarp;
import com.zhiyou100.service.video.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoDao vm;
	@Override
	public void delvideo(Integer id) {
		vm.delvideo(id);
	}
	@Override
	public Video findone(Integer id) {
		
		return vm.findone(id);
	}
	@Override
	public List<Video> findterm(String searchvideoTitle, String searchcourseId, String searchspeakerId,
			Integer currentpage) {
		
		SearchVideo sv=new SearchVideo();
		sv.setCourseid(searchcourseId);
		sv.setCurrentpage((currentpage-1)*10);
		sv.setSpeakerid(searchspeakerId);
		sv.setTitle(searchvideoTitle);
		return vm.findall(sv);
	}
	@Override
	public int addvideo(Video video) {
		
		return vm.addvideo(video);
	}
	@Override
	public int updatevideo(Video video) {
		return 0;
	}
	@Override
	public void batch(String id) {
		vm.batch(id);
	}
	@Override
	public List<CourseWarp> avgtimes() {
		List<Object[]> list=vm.avgtimes();
		List<CourseWarp> coursewarp=new ArrayList<>();
		for(Object[] object:list){
			CourseWarp cw=new CourseWarp();
			cw.setId((Integer)object[0]);
			cw.setCourseName((String)object[1]);
			String str=object[2].toString();
			cw.setAvgtimes(Integer.parseInt(str));
			coursewarp.add(cw);
		}
		return coursewarp;
	}
	@Override
	public int count(String searchvideoTitle, String searchcourseId, String searchspeakerId) {
		// TODO Auto-generated method stub
		return vm.count(searchvideoTitle,searchcourseId,searchspeakerId);
	}
	@Override
	public List<Video> findcourseid(Integer id) {
		// TODO Auto-generated method stub
		return vm.findcourseid(id);
	}
	
}
