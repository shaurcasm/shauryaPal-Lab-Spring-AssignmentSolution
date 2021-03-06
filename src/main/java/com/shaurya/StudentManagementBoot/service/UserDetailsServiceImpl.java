package com.shaurya.StudentManagementBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.shaurya.StudentManagementBoot.entity.User;
import com.shaurya.StudentManagementBoot.repository.UserRepository;
import com.shaurya.StudentManagementBoot.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user by Username" + username);
		}
		
		return new MyUserDetails(user);
	}

}
