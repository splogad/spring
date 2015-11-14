package com.splogad.myapp.validation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.splogad.myapp.dto.SignupForm;
import com.splogad.myapp.entities.User;
import com.splogad.myapp.repositories.UserRepository;

@Component
public class SignupFormValidator extends LocalValidatorFactoryBean {

	private UserRepository userRepository;
	
	@Resource
	public void setUserRepo(UserRepository u){
		this.userRepository = u;
	}
	
	@Override
	public boolean supports(Class<?> clazz){
		return clazz.isAssignableFrom(SignupForm.class);
	}
	
	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints){
		super.validate(obj,errors,validationHints);
		
		if(!errors.hasErrors()){
			SignupForm signupForm = (SignupForm) obj;
			User user = userRepository.findByEmail(signupForm.getEmail());
			
			if (user !=null){
				errors.rejectValue("email", "emailNotUnique");
			}
		}
	}
}
