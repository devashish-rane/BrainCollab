package com.deva.braincollab.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public long createNewUser(User userData) {
		userRepo.save(userData);
		return userData.getUserId();
	}
	
	public Optional<User> getUser(long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
