package com.zhiyou100.dao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zhiyou100.dao.dao.VideoDao;
import com.zhiyou100.dao.model.Admin;
import com.zhiyou100.dao.model.Video;
import com.zhiyou100.dao.warp.CourseWarp;
import com.zhiyou100.dao.warp.SearchVideo;
import com.zhiyou100.dao.warp.VideoWarp;

@SuppressWarnings("unchecked")
public class VideoDaoImpl extends HibernateDaoSupport implements VideoDao {

	
	@Override
	public List<Video> findall(SearchVideo sv) {
		DetachedCriteria dc=DetachedCriteria.forClass(Video.class);
		if(!sv.getTitle().equals("")){
			dc.add(Restrictions.like("videoTitle", "%"+sv.getTitle()+"%"));
		}
		if(!sv.getCourseid().equals("0")){
			dc.add(Restrictions.eq("course.id", Integer.parseInt(sv.getCourseid())));
			
		}
		if(!sv.getSpeakerid().equals("0")){
			dc.add(Restrictions.eq("speaker.id", Integer.parseInt(sv.getSpeakerid())));
			
		}
		List<Video> findByCriteria = (List<Video>) getHibernateTemplate().findByCriteria(dc,sv.getCurrentpage(),10);
		return findByCriteria;
	}

	@Override
	public int count(String searchvideoTitle, String searchcourseId, String searchspeakerId) {
		DetachedCriteria dc=DetachedCriteria.forClass(Video.class);
		if(!searchvideoTitle.equals("")){
			dc.add(Restrictions.like("videoTitle", "%"+searchvideoTitle+"%"));
		}
		if(!searchcourseId.equals("0")){
			dc.add(Restrictions.eq("course.id", Integer.parseInt(searchcourseId)));
			
		}
		if(!searchspeakerId.equals("0")){
			dc.add(Restrictions.eq("speaker.id", Integer.parseInt(searchspeakerId)));
			
		}
		List<Video> findByCriteria = (List<Video>) getHibernateTemplate().findByCriteria(dc);
		return findByCriteria.size();
	}

	@Override
	public Video findone(Integer id) {
		DetachedCriteria dc=DetachedCriteria.forClass(Video.class).add(Restrictions.idEq(id));
		
		return  (Video) getHibernateTemplate().findByCriteria(dc).get(0);
	}

	@Override
	public void delvideo(Integer id) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		String sql = "delete from video where id= ?";   
		getSessionFactory().getCurrentSession().createSQLQuery(sql).setInteger(0, id).executeUpdate();  
	}

	@Override
	public int addvideo(Video video) {
		getHibernateTemplate().saveOrUpdate(video);
		return 0;
	}

	@Override
	public void batch(String id) {
		// TODO Auto-generated method stub
		String sql="delete from video where id in ("+id+")";
		getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public List<Object[]> avgtimes() {
		String sql="SELECT c.id id,c.course_name courseName,ROUND(avg(v.video_play_times)) avgtimes from course c "+
		"LEFT JOIN video v ON c.id=v.course_id GROUP BY c.id";
		List<Object[]> obj=getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
		return obj;
	}

	@Override
	public List<Video> findcourseid(Integer id) {
		// TODO Auto-generated method stub
		return (List<Video>) getHibernateTemplate().find("from Video v left join fetch v.course c where c.id=?", id);
	}

	

}
