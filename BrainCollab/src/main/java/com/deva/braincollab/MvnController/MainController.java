package com.deva.braincollab.MvnController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deva.braincollab.Entity.Blog;
import com.deva.braincollab.Service.UserService;


@Controller
public class MainController {	
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("username","teporary username");
		return "home";
	}
	
	@RequestMapping("blogs/{user_id}")
	public String listBlogs(@PathVariable("user_id") Long  id, Model model) {
		
		List<Blog> blogsList = userService.getUser(id).get().getBlogs();
		model.addAttribute("blog_list",blogsList);
		return "blogs";
	}
	
}
