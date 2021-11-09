package com.Dverm.Dao;

import java.util.List;

import com.Dverm.entity.Subreddit;

public interface SubredditDao {
	
	//Need to execute query which will retrieve matching subreddits based on input username and profile.
	public List<String> findSubredditsOnProfile(String username, String profile);
	
	//Need to execute query which will find unique profile entries based on username. REMEMBER List<String>
	public List<String> findUniqueProfiles(String username);
	
	//Need to execute query based to save a subreddit on the proper username and profile field.
	public void saveSubreddit(Subreddit subreddit);
	
	//Need to execute query which will add a profile corresponding to the username
	//Need Strategy for empty subreddit column (Or just have 1 row with null subreddit for each profile?)
	public void saveProfile(Subreddit subreddit);
	
	//Need to execute query to delete a row in table having a proper username and profile.
	public void deleteSubreddit(Subreddit subreddit);
	
	//Need to execute query which will delete all rows in table who have matching username and profile.
	public void deleteProfile(String theUsername, String theProfile);
	
	//Need to execute query which will delete all rows in table who have matching username and profile.
	public void renameProfile(String theUsername, String theProfile, String newProfile);
}
