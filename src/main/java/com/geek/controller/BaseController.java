package com.geek.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.geek.domain.User;
import com.geek.repository.UserDao;

public class BaseController{

	@Resource 
	private UserDao userDao;
	
	public User getSessionUser(HttpSession httpSession) throws UsernameNotFoundException{
		if(SecurityContextHolder.getContext().getAuthentication().getName()==null){
			throw new UsernameNotFoundException(String.format("User with username=%s was not found", ""));
		}
		if(httpSession.getAttribute("user")==null){
			return new User();
		}
		User user = userDao.findByAccount(SecurityContextHolder.getContext().getAuthentication().getName());
		return user;
	}
}
