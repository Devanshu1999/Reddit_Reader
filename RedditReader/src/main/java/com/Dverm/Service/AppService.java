package com.Dverm.Service;

import java.util.List;

import com.Dverm.entity.Subreddit;
import com.Dverm.entity.User;
import com.Dverm.entity.WebData;

public interface AppService {
	public User findUser(String username);
	
	public void saveUser(User user);
	
	public List<String> findSubredditsOnProfile(String username, String profile);
	
	public List<String> findUniqueProfiles(String username);
	
	public void saveSubreddit(Subreddit subreddit);
	
	public void saveProfile(Subreddit subreddit);
	
	public void deleteSubreddit(Subreddit subreddit);
	
	public void deleteProfile(String theUsername, String theProfile);
	
	public void renameProfile(String theUsername, String theProfile, String newProfile);
	
	public List<WebData> retrieveWebData(String subredditName);
}
