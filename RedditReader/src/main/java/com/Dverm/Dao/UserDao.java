package com.Dverm.Dao;

import com.Dverm.entity.User;

public interface UserDao {
	
	public User findUser(String username);
	
	public void saveUser(User user);
}
