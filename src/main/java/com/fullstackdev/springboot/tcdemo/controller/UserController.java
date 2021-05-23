package com.fullstackdev.springboot.tcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdev.springboot.tcdemo.entity.User;
import com.fullstackdev.springboot.tcdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public User saveUser(@RequestBody  User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getSortedUsers")
	public List<User> getAllUsersSortByUsertype() {		
		return userService.getAllUsersSortByUsertype();
	}
	


}
