package com.lzj.springcloud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.lzj.springcloud.entity.User;

@RestController
public class UserConsumerController {
//	private static String REST_URL_PREFIX = "http://localhost:8002";
	/*直接根据微服务名调用，而不再是根据地址和端口了，运用了eureka的发现功能*/
	private static String REST_URL_PREFIX = "http://microservicecloud-provider";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/add")
	public boolean addUser(User user){
		Boolean flag = restTemplate.postForObject(REST_URL_PREFIX + "/add", user, Boolean.class);
		return flag;
	}
	
	@RequestMapping(value="/consumer/get/{id}")
	public User get(@PathVariable("id") int id){
		User user = restTemplate.getForObject(REST_URL_PREFIX + "/get/" + id, User.class);
		return user;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/consumer/list")
	public List<User> getList(){
		List list = restTemplate.getForObject(REST_URL_PREFIX + "/getUser/list", List.class);
		return list;
	}
}
