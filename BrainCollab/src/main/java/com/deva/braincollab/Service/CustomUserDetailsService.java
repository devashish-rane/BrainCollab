package com.deva.braincollab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deva.braincollab.Entity.CustomUserDetails;
import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Repository.UserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepo.findByName(username);

		if(user==null) {
			throw new UsernameNotFoundException("User with given name not found");
		}
		else {
			
		}
		return new CustomUserDetails(user);
	}

}
