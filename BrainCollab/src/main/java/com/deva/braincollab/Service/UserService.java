package com.deva.braincollab.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Repository.UserRepo;

public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public long createNewUser(User userData) {
		userRepo.save(userData);
		return userData.getId();
	}
	
	public Optional<User> getUser(long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}
}
