package com.account.create.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/createAccount",method=RequestMethod.POST)
	public ResponseEntity<Object> createAccount(@RequestBody User user){
		return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
	}
}
