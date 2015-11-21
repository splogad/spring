package com.splogad.myapp.controllers;

import java.lang.ProcessBuilder.Redirect;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.splogad.myapp.dto.SignupForm;
import com.splogad.myapp.email.EmailSender;
import com.splogad.myapp.email.MockEmailSender;
import com.splogad.myapp.repositories.UserRepository;
import com.splogad.myapp.services.UserService;
import com.splogad.myapp.util.messageUtil;
import com.splogad.myapp.validation.SignupFormValidator;

@Controller //@RestController
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	private SignupFormValidator signupFormValidator; 
	@Value("${spring.profiles.active}")
	private String profile;
	private UserService userService;
	//@Resource	//(name="MockEmailSender2")
	private EmailSender em;
	
	@Autowired
	public RootController(EmailSender em, UserService userService,SignupFormValidator signupFormValidator){
		this.em = em;
		this.userService = userService;
		this.signupFormValidator=signupFormValidator;
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

	@InitBinder("signupForm")
	protected void initSignupBinder (WebDataBinder binder){
		binder.setValidator(signupFormValidator);
	}
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") @Valid SignupForm signupForm,
			BindingResult result, RedirectAttributes att){
		
		if(result.hasErrors())
			return "signup";
		
		userService.signup(signupForm);
		logger.info(signupForm.toString());
		
		messageUtil.flash(att, "success",
				"signupSuccess");
		
		return "redirect:/";
	}	
	
	@RequestMapping("/search")
	public String search(){
		
		return "search";
	}

}
