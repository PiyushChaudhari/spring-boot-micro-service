package com.account.create.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.create.model.User;
import com.account.create.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Value("${server.port}")
	String port;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/createAccount",method=RequestMethod.POST)
	public ResponseEntity<Object> createAccount(@RequestBody User user){
		log.info("Running on port number:> {}",port);
		return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
	}
}
