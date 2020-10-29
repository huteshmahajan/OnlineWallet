package com.cg.LoginDatabaseProviderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/logindb")
public class UserController {
	@Autowired
	private UserRepository repository;

	@Autowired
	private Environment env;

	@Autowired
	private UserServiceImpl service;

	// retrieve all users

	@GetMapping("/getusers")
	public @ResponseBody List<User> getUsers() {

		List<User> tempList = new ArrayList<User>();

		tempList = service.getUsers();
		return tempList;
	}
	
	// add user
	@PostMapping("/adduser")
	public boolean createUser(@RequestBody User user)
	{
		
		User newuser=repository.save(user);
		if(newuser!=null)
			return true;
		return false;
	}
	

	// Validate User

	@PostMapping("/login/username/{uname}/passWord/{pass}")
	public User validateUser(@PathVariable("uname") String uname, @PathVariable("pass") String pass) {
		System.out.println("inside login provider validate controller");
		User user = repository.findByuserNameAndPassword(uname, pass);
		return user;
	}

}
