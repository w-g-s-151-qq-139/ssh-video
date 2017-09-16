package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.SpeakerDao;
import com.zhiyou100.dao.model.Speaker;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.SearchSpeaker;


public class SpeakerDaoImpl extends HibernateDaoSupport implements SpeakerDao {

	@Override
	public List<Speaker> findall() {
		// TODO Auto-generated method stub
		return (List<Speaker>) getHibernateTemplate().find("from Speaker");
	}

	@Override
	public Speaker findone(Integer id) {
		
		return (Speaker) getHibernateTemplate().find("from Speaker where id=?", id).get(0);
	}

	@Override
	public List<Speaker> search(SearchSpeaker speaker) {
		DetachedCriteria dc=DetachedCriteria.forClass(Speaker.class);
		if(!speaker.getSearchspeakerName().equals("")){
			dc.add(Restrictions.like("speakerName", "%"+speaker.getSearchspeakerName()+"%"));
		}
		if(!speaker.getSearchspeakerJob().equals("")){
			dc.add(Restrictions.like("speakerJob", "%"+speaker.getSearchspeakerJob()+"%"));
			
		}
		
		List<Speaker> findByCriteria = (List<Speaker>) getHibernateTemplate().findByCriteria(dc,speaker.getPage(),10);
		return findByCriteria;
	}

	@Override
	public int count(SearchSpeaker speaker) {
		DetachedCriteria dc=DetachedCriteria.forClass(Speaker.class);
		if(!speaker.getSearchspeakerName().equals("")){
			dc.add(Restrictions.like("speakerName", "%"+speaker.getSearchspeakerName()+"%"));
		}
		if(!speaker.getSearchspeakerJob().equals("")){
			dc.add(Restrictions.like("speakerJob", "%"+speaker.getSearchspeakerJob()+"%"));
			
		}
		
		List<Speaker> findByCriteria = (List<Speaker>) getHibernateTemplate().findByCriteria(dc);
		return findByCriteria.size();
	}

	@Override
	public void addspeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(speaker);
	}

	@Override
	public void del(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from speaker where id= ?";   
		getSessionFactory().getCurrentSession().createSQLQuery(sql).setInteger(0, id).executeUpdate();
	}

}
