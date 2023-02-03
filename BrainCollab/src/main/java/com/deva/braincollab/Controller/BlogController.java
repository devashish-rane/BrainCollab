package com.deva.braincollab.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deva.braincollab.Entity.Blog;
import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Repository.UserRepo;
import com.deva.braincollab.Service.BlogService;
import com.deva.braincollab.Service.UserService;

@RestController
@RequestMapping("/api")
public class BlogController {
	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/get_blog/{id}")
	public ResponseEntity<?> getBlogApi(@PathVariable("id") long id){

		Optional<Blog> blog = blogService.getBlog(id);
		if(blog.isPresent()) {
			return new ResponseEntity<>(blog,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Blog not present with given ID",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create_blog/{user_id}")
	public ResponseEntity<?> createBlogApi(@RequestBody Blog newBlog,@PathVariable("user_id") Long id){
		
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			User userc = user.get();
			newBlog.setAuthor(userc);
			Blog savedBlog = blogService.createNewBlog(newBlog);
			
			System.out.println("user saved to blog");
			List<Blog> listBlog = userc.getBlogs();
			listBlog.add(savedBlog);
			userc.setBlogs(listBlog);
			userService.saveUser(userc);
			System.out.println("done");
		}
		
		return new ResponseEntity<>("Blog created",HttpStatus.OK);
	}
	
	@GetMapping("/get_blogs/{user_id}")
	public ResponseEntity<?> getBlogApi(@PathVariable("user_id") Long id){
		
		Optional<User> user = userService.getUser(id);
		List<Blog> blogList= new ArrayList<>();
		System.out.println("mymy");
		if(user.isPresent()) {
			blogList = user.get().getBlogs();
			System.out.println(blogList);
		}
		
		return new ResponseEntity<>(blogList,HttpStatus.OK);
	}

}
