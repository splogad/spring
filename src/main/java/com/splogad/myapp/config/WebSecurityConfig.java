package com.splogad.myapp.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Resource
	private UserDetailsService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/",
				"/error",
				"/signup",
				"/search",
				"/forgot-password",
				"/reset-password/*",
				"/resources/**",
				"/public/**").permitAll()
		.anyRequest().authenticated();
		
		http.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
	}
	
	@Autowired
	@Override  //usato per la gestione dei login e che dobbiamo ora creare.
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception{
		authBuilder.userDetailsService(userService);
	}
}
