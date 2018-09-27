package com.lzj.springcloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lzj.springcloud.entity.User;
import com.lzj.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="hystrixGetUser") //一旦服务调用失败，就调用hystrixGetUser方法
	public User getUser(@PathVariable("id") int id){
		User user = service.getUser(id);
		if(user == null){
			throw new RuntimeException("不存在id=" + id + "对应的用户信息");
		}
		return user;
	}
	
	public User hystrixGetUser(@PathVariable("id") int id){
		User user = new User(id, "不存在该用户", 0);
		return user;
	}

}
