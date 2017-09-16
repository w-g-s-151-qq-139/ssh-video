package com.zhiyou100.dao.dao;

import java.util.List;

import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.warp.SearchSpeaker;

public interface SpeakerDao {

	List<Speaker> findall();

	Speaker findone(Integer id);

	List<Speaker> search(SearchSpeaker speaker);

	int count(SearchSpeaker speaker);

	void addspeaker(Speaker speaker);

	void del(Integer id);

}
