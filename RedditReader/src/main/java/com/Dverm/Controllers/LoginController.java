package com.Dverm.Controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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

import com.Dverm.Service.AppService;
import com.Dverm.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	private AppService appService;
	
	/* Adding @InitBinder to trim input strings when filling out username and password fields 
	 * This removes leading and trailing white-spaces.
	 * Required for form validation.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/")
	public String getWelcome() {
		return "HomePage";
	}
	
	@GetMapping("/showLoginPage")
	public String showLoginPage(Model theModel) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        	User theUser = new User();
        	theModel.addAttribute("myUser", theUser);
            return "LoginPage";
        }
       	authentication = null;
       	SecurityContextHolder.getContext().setAuthentication(authentication);
 
        return "redirect:/";
		
//		User theUser = new User();
//		theModel.addAttribute("myUser", theUser);
//		return "LoginPage";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model theModel) {
		
		User user = new User();
		
		theModel.addAttribute("theUser", user);
		
		return "RegistrationForm";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("theUser") User theUser, BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "RegistrationForm";
		}
		
		User testUser = appService.findUser(theUser.getUsername());
		
		if(testUser != null) {
			theModel.addAttribute("theUser", new User());
			theModel.addAttribute("errorMessage", "User already exist"); 
			return "RegistrationForm";
		}
		
		appService.saveUser(theUser);
		
		return "redirect:/showLoginPage";
	}
}
