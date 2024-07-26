package com.dat.learninghub.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dat.learninghub.model.User;
import com.dat.learninghub.repository.UserRepository;

public class OurUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByName(name);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new LoginUserDetail(user.get());
	}
	
		

}
