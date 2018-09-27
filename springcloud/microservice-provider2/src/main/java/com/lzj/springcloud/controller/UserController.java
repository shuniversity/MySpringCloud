package com.lzj.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lzj.springcloud.entity.User;
import com.lzj.springcloud.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public boolean addUser(@RequestBody User user){
		boolean flag = service.addUser(user);
		return flag;
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id") int id){
		User user = service.getUser(id);
		return user;
	}
	
	@RequestMapping(value="/getUser/list", method=RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = service.getUsers();
		return users;
	}
}
