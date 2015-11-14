package com.splogad.myapp.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.splogad.myapp.dto.SignupForm;
import com.splogad.myapp.email.EmailSender;
import com.splogad.myapp.email.MockEmailSender;

@Controller //@RestController
public class RootController {
	
	@Value("${spring.profiles.active}")
	private String profile;

	//@Resource	//(name="MockEmailSender2")
	private EmailSender em;
	
	@Autowired
	public RootController(EmailSender em){
		this.em = em;
	}
		
//	@RequestMapping("/")
//	public String home(){
//		//em.send("splogad@gmail.com", "Test email", "Test Body");
//		//return "("+profile+")"+"<br>"+"Hello, World!!";
//		return "home";
//	}	

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model){
		//model.addAttribute("signupForm", new SignupForm());stessa cosa di sotto
		model.addAttribute(new SignupForm());
		return "signup";
	}	

	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") @Valid SignupForm signupForm,
			BindingResult result){
		
		if(result.hasErrors())
			return "signup";
		
		logger.info(signupForm.toString());
		return "redirect:/welcome";
	}	
	
	@RequestMapping("/welcome")
	public String welcome(){
		
		return "welcome";
	}

}
