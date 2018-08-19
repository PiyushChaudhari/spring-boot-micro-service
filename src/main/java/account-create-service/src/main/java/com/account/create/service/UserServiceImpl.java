package com.account.create.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.account.create.dao.UserDao;
import com.account.create.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public User save(User user) {
		log.info("save user:> {} ",user);
		User u = userDao.save(user);
		if(null !=u) {
			sendNotification(u);
		}
		return u;
	}
	
	private void sendNotification(User u) {
		List<ServiceInstance> instances = discoveryClient.getInstances("notification-service");
		ServiceInstance serviceInstance = instances.get(0);

		StringBuilder baseUrl = new StringBuilder(serviceInstance.getUri().toString());
		baseUrl.append("/notification/registration/welcome");
		
		Map<String,String> modelMap = new HashMap<>();
		
		modelMap.put("to",u.getEmail());
		modelMap.put("name",u.getFirstName());
		modelMap.put("signature","Notification Team");
		modelMap.put("location","Ahmedabad");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(baseUrl.toString(), modelMap, String.class);
		log.info("result:> {} ",result);
	}

}
