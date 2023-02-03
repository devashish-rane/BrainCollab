package com.deva.braincollab.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deva.braincollab.Entity.Blog;
import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Repository.BlogRepo;

@Service
public class BlogService {
	@Autowired
	private BlogRepo blogRepo;
	
	public Blog createNewBlog(Blog blog) {
		blogRepo.save(blog);
		return blog;
	}
	
	public Optional<Blog> getBlog(long id) {
		Optional<Blog> blog = blogRepo.findById(id);
		return blog;
	}
	
//	public List<Blog> getAllBlogsForUser(User user) {
//		List<Blog> blog = blogRepo.findByAuthor(user);
//		return blog;
//	}
}
