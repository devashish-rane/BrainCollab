package com.deva.braincollab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deva.braincollab.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	 User findByName(String name);
	
}
