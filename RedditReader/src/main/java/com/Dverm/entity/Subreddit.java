package com.Dverm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subreddits")
public class Subreddit {
	public Subreddit() {
		
	}
	
	public Subreddit(String username, String subreddit, String profile) {
		this.username = username;
		this.subreddit = subreddit;
		this.profile = profile;
	}
	
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "subreddit")
	private String subreddit;
	
	@NotNull(message = "Profile field cannot be empty")
	@Size(min = 1, message = "Profile length should be atleast 1")
	@Column(name = "profile")
	private String profile;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit.toLowerCase();
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Subreddit [username=" + username + ", subreddit=" + subreddit + ", profile=" + profile + "]";
	}
}
