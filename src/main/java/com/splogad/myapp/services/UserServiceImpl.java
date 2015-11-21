package com.splogad.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.splogad.myapp.dto.SignupForm;
import com.splogad.myapp.dto.UserDetailsImpl;
import com.splogad.myapp.entities.User;
import com.splogad.myapp.repositories.UserRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService{
	
	private UserRepository userRepo;
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, 
			BCryptPasswordEncoder passEncoder) {
		this.userRepo = userRepository;
		this.passEncoder = passEncoder;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly = false)
	@Override
	public void signup(SignupForm signupForm) {
		//code to write the user into db
		User user = new User();
		user.setEmail(signupForm.getEmail());
		user.setName(signupForm.getName());
		user.setPassword(passEncoder.encode(signupForm.getPassword()));
		
		userRepo.save(user);
		//int j = 20/0;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(userName);
		if(user==null)
			throw new UsernameNotFoundException(userName);
		
		return new UserDetailsImpl(user);
	}

	
}
