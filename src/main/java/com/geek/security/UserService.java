package com.geek.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.geek.domain.User;
import com.geek.repository.UserDao;


@Component
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByAccount(username);
		if(user.getPasswd()==null){
			throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
		}
		return user;
	}

}
