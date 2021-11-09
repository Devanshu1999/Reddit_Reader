package com.Dverm.Service;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dverm.Dao.SubredditDao;
import com.Dverm.Dao.UserDao;
import com.Dverm.entity.Subreddit;
import com.Dverm.entity.User;
import com.Dverm.entity.WebData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SubredditDao subredditDao;

	@Override
	@Transactional
	public User findUser(String username) {
		return userDao.findUser(username);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional
	public List<String> findSubredditsOnProfile(String username, String profile) {
		return subredditDao.findSubredditsOnProfile(username, profile);
	}

	@Override
	@Transactional
	public List<String> findUniqueProfiles(String username) {
		return subredditDao.findUniqueProfiles(username);
	}

	@Override
	@Transactional
	public void saveSubreddit(Subreddit subreddit) {
		subredditDao.saveSubreddit(subreddit);
	}

	@Override
	@Transactional
	public void saveProfile(Subreddit subreddit) {
		subredditDao.saveProfile(subreddit);		
	}

	@Override
	@Transactional
	public void deleteSubreddit(Subreddit subreddit) {
		subredditDao.deleteSubreddit(subreddit);
	}

	@Override
	@Transactional
	public void deleteProfile(String theUsername, String theProfile) {
		subredditDao.deleteProfile(theUsername, theProfile);
	}

	@Override
	@Transactional
	public void renameProfile(String theUsername, String theProfile, String newProfile) {
		subredditDao.renameProfile(theUsername, theProfile, newProfile);
	}

	@Override
	public List<WebData> retrieveWebData(String subredditName) {
		List<WebData> dataList = null;
		try {
			URL url = new URL("https://www.reddit.com/r/"+ subredditName.strip() + "/top.json?limit=5&t=day");
			
			URLConnection request = url.openConnection();
			//Need this to tackle HTTP response code: 429---"Too many requests"---reddit requires an user agent
			request.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
			
			DocumentContext context = JsonPath.parse(request.getInputStream());
			//List<WebData> nodes = context.read("$..children[*].data");
			
			ObjectMapper mapper = new ObjectMapper();
	        CollectionType dataType = mapper.getTypeFactory().constructCollectionType(List.class, WebData.class);
	        dataList = mapper.convertValue(context.read("$..children[*].data"), dataType);

		}
		catch(Exception e) {
			return null;
		}
		if(dataList.size() == 0) {
			return null;
		}
		else {
			return dataList;
		}
	}
}
