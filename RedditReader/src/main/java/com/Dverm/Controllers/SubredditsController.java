package com.Dverm.Controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.RequestScope;

import com.Dverm.Service.AppService;
import com.Dverm.entity.Subreddit;
import com.Dverm.entity.WebData;

@Controller
@RequestMapping("/showProfile")
@SessionAttributes({"theProfile", "theUsername"})
@RequestScope
public class SubredditsController {
	
	@Autowired
	public AppService appService;
	
	private static String username;
	private static String profile;                                                                                                                   
	private static List<String> subredditList;
	private static List<List<WebData>> dataList;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/initializing")
	public String showProfile(@RequestParam("profile") String pfile,
								@ModelAttribute("theUsername") String uname, Model theModel) {
		username = uname;
		profile = pfile;
		theModel.addAttribute("theProfile", pfile);
		return "redirect:/showProfile/mySubreddits";
	}
	
	@GetMapping("/mySubreddits")
	public String yourSubreddits(@ModelAttribute("theProfile") String pfile, Model theModel) {
		theModel.addAttribute("theProfile", pfile);
		
		subredditList = appService.findSubredditsOnProfile(username, profile);
		
		dataList = new LinkedList<>();
		
		for(String subr : subredditList) {
			dataList.add(appService.retrieveWebData(subr));
		}
		
		theModel.addAttribute("dataList", dataList);
		
//		[WebData [subreddit=dankmemes, title=nice how this sub has no rule against low effort titles, url=https://i.redd.it/lcnfypy781v71.png, num_comments=501, author=FlatMarzipan, score=51231, url_overridden_by_dest=https://i.redd.it/lcnfypy781v71.png]
//		System.out.println(username);
//		System.out.println(profile);
//		System.out.println(subredditList);
//		System.out.println(dataList);
		
		return "SubredditsPage";
	}
	
	@GetMapping("/addSubreddit")
	public String addSubreddit(Model theModel) {
		return "SaveSubreddit";
	}
	
	@PostMapping("/saveSubreddit")
	public String saveSubreddit(@RequestParam("theSubreddit") String subredditName, Model theModel) {
		subredditName = subredditName.toLowerCase().strip();
		Subreddit theSubreddit = new Subreddit(username, subredditName, profile);
//		System.out.println(username);
//		System.out.println(profile);
//		System.out.println(subredditName);
		
		if(subredditList != null && subredditList.contains(subredditName)) {
			theModel.addAttribute("errorMessage", "Subreddit already exists on this profile.");
			return "SaveSubreddit";
		}
		
		//Validate if subreddit exists or not
		List<WebData> dataList = appService.retrieveWebData(subredditName);
		
		if(dataList == null) {
			theModel.addAttribute("errorMessage", "Subreddit doesn't exist");
			return "SaveSubreddit";
		}
		
		appService.saveSubreddit(theSubreddit);
		
		return "redirect:/showProfile/mySubreddits";
	}
	
	@GetMapping("/deleteSubreddit")
	public String deleteSubreddit(@RequestParam("subredditName") String subredditName) {
		Subreddit theSubreddit = new Subreddit(username, subredditName, profile);
		appService.deleteSubreddit(theSubreddit);
		return "redirect:/showProfile/mySubreddits";
	}
}

