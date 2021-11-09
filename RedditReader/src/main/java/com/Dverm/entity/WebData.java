package com.Dverm.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebData {
	private String subreddit;
	private String title;
	private String permalink;
	private String num_comments;
	private String selftext;
	private String score;
	private String url_overridden_by_dest;
	
	public WebData(){
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = "https://www.reddit.com" + permalink;
	}

	public String getNum_comments() {
		return num_comments;
	}

	public void setNum_comments(String num_comments) {
		this.num_comments = num_comments;
	}

	public String getSelftext() {
		return selftext;
	}

	public void setSelftext(String selftext) {
		this.selftext = selftext;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getUrl_overridden_by_dest() {
		return url_overridden_by_dest;
	}

	public void setUrl_overridden_by_dest(String url_overridden_by_dest) {
		this.url_overridden_by_dest = url_overridden_by_dest;
	}

	public String getSubreddit() {
		return subreddit;
	}

	public void setSubreddit(String subreddit) {
		this.subreddit = subreddit;
	}

	@Override
	public String toString() {
		return "WebData [subreddit=" + subreddit + ", title=" + title + ", permalink=" + permalink + ", num_comments="
				+ num_comments + ", author=" + selftext + ", score=" + score + ", url_overridden_by_dest="
				+ url_overridden_by_dest + "]";
	}
}