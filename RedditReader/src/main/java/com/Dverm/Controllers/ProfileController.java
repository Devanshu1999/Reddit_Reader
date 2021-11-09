package com.Dverm.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Dverm.Service.AppService;
import com.Dverm.entity.Subreddit;

@Controller
@RequestMapping("/userProfile")
@SessionAttributes("theUsername")
public class ProfileController {
	
	@Autowired
	private AppService appService;
	
	private String username;
	
	/* Adding @InitBinder to trim input strings when filling out username and password fields 
	 * This removes leading and trailing white-spaces.
	 * Required for form validation.
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@PostMapping("/showWelcome")
	public String profilePage(Model theModel) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		theModel.addAttribute("theUsername", username);
		this.username = username;
		return "redirect:/userProfile/welcome";
	}
	
	@GetMapping("/welcome")
	public String showWelcome(Model theModel) {
		theModel.addAttribute("theUser", username);
		
		List<String> profiles = appService.findUniqueProfiles(username);
		
		if(profiles.size() == 0) {
			theModel.addAttribute("errorMessage", "You don't have any profiles set. Please add a profile.");
			return "ProfilesPage";
		}
		
		theModel.addAttribute("theProfiles", profiles);
		
		return "ProfilesPage";
	}
	
	@GetMapping("/addProfilePage")
	public String addProfilePage(Model theModel) {
		Subreddit subreddit = new Subreddit();
	    theModel.addAttribute("saveProfile", subreddit);
		return "CreateProfile";
	}
	
	@PostMapping("/saveProfile")
	public String saveProflie(@Valid @ModelAttribute("saveProfile") Subreddit theSubreddit, BindingResult result,
									Model theModel) {
		if(result.hasErrors()) {
			return "CreateProfile";
		}
		theSubreddit.setUsername(username);
		
		List<String> profiles = appService.findUniqueProfiles(username);
		for(String prof : profiles) {
			if(prof.equalsIgnoreCase(theSubreddit.getProfile())) {
				theModel.addAttribute("errorMessage", "Profile already exists");
				return "CreateProfile";
			}
		}
		appService.saveSubreddit(theSubreddit);
		return "redirect:/userProfile/welcome";
	}
	
	@GetMapping("/deleteProfile")
	public String deleteProfile(@RequestParam("profile") String profile) {
		appService.deleteProfile(username, profile);
		return "redirect:/userProfile/welcome";
	}
	
	@GetMapping("/renameProfile")
	public String renameProfile(@RequestParam("profile") String oldProfile, Model theModel) {
		theModel.addAttribute("oldProfile", oldProfile);
		return "RenameProfile";
	}
	
	@PostMapping("/saveNewProfile")
	public String saveNewProfile(@RequestParam("oldProfile") String oldProfile, @RequestParam("newProfile")
										 String newProfile, Model theModel) {
		
		if(oldProfile.equalsIgnoreCase(newProfile)) {
			appService.renameProfile(username, oldProfile, newProfile);
			return "redirect:/userProfile/welcome";
		}
		
		List<String> tempList = appService.findUniqueProfiles(username);
		
		for(String existingProfile : tempList) {
			if(existingProfile.equalsIgnoreCase(newProfile)) {
				theModel.addAttribute("errorMessage", "Profile already exist, choose a different name please.");
				theModel.addAttribute("oldProfile", oldProfile);
				return "RenameProfile";
			}
		}
		
		appService.renameProfile(username, oldProfile, newProfile);
		
		return "redirect:/userProfile/welcome";
	}
}