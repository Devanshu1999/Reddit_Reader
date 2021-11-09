package com.Dverm.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dverm.entity.Subreddit;

@Repository
public class SubredditDaoImpl implements SubredditDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveSubreddit(Subreddit subreddit) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(subreddit);
	}

	@Override
	public List<String> findSubredditsOnProfile(String username, String profile) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<String> query = session.createQuery("SELECT S.subreddit FROM Subreddit S WHERE S.username =: theUsername AND S.profile =: theProfile AND S.subreddit IS NOT NULL");
		
		query.setParameter("theUsername", username);
		query.setParameter("theProfile", profile);
		
		List<String> list = query.getResultList();
		
		return list;
	}

	@Override
	public List<String> findUniqueProfiles(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<String> query = session.createQuery("SELECT DISTINCT S.profile FROM Subreddit S WHERE S.username =: theUsername");
		
		query.setParameter("theUsername", username);
		
		List<String> list = query.getResultList();
		
		return list;
	}

	@Override
	public void saveProfile(Subreddit subreddit) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(subreddit);
	}

	@Override
	public void deleteSubreddit(Subreddit subreddit) {
		Session session = sessionFactory.getCurrentSession();

		Query query = 
				session.createQuery("delete from Subreddit where username=:uname AND profile=:pfile AND subreddit=:sreddit");
		query.setParameter("uname", subreddit.getUsername());
		query.setParameter("pfile", subreddit.getProfile());
		query.setParameter("sreddit", subreddit.getSubreddit());
		
		query.executeUpdate();
		
	}

	@Override
	public void deleteProfile(String theUsername, String theProfile) {
		Session session = sessionFactory.getCurrentSession();

		Query query = 
				session.createQuery("delete from Subreddit where username=:uname AND profile=:pfile");
		query.setParameter("uname", theUsername);
		query.setParameter("pfile", theProfile);
		
		query.executeUpdate();
	}

	@Override
	public void renameProfile(String theUsername, String theProfile, String newProfile) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = 
				session.createQuery("UPDATE Subreddit s SET s.profile=:newPfile WHERE s.username=:uname AND s.profile=:pfile");
		query.setParameter("newPfile", newProfile);
		query.setParameter("uname", theUsername);
		query.setParameter("pfile", theProfile);
		
		query.executeUpdate();
	}

}
