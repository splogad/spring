package com.splogad.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splogad.myapp.dto.SignupForm;
import com.splogad.myapp.entities.User;
import com.splogad.myapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepo = userRepository;
	}

	@Override
	public void signup(SignupForm signupForm) {
		//code to write the user into db
		User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(signupForm.getPassword());
		
		userRepo.save(user);
	}

	
}
