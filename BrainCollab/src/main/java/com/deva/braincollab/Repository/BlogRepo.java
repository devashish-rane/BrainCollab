package com.deva.braincollab.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deva.braincollab.Entity.Blog;
import com.deva.braincollab.Entity.User;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long>{
		Blog findByName(String name);
		
//		List<Blog> findByAuthor(User user);
	
}