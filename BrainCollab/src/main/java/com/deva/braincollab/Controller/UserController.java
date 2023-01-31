package com.deva.braincollab.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deva.braincollab.Entity.User;
import com.deva.braincollab.Service.UserService;

@RestController
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/get_user/{id}")
	public ResponseEntity<?> getUserApi(@PathVariable("id") long id){
		System.out.println("dev");
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User not present with given ID",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/create_user")
	public ResponseEntity<?> createUserApi(@RequestBody User newUser){
		Long savedID = userService.createNewUser(newUser);
		return new ResponseEntity<>("User created"+ savedID,HttpStatus.OK);
	}
}
