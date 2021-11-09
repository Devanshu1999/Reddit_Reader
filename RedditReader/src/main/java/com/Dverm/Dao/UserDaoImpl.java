package com.Dverm.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dverm.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	// Injecting the SessionFactory (Injected from LocalSessionFactoryBean @Bean in AppConfig.java)
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User theUser = session.get(User.class, username);
		
		return theUser;
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(user);
		System.out.println("Successfully registered - " + user.toString());
	}

}
