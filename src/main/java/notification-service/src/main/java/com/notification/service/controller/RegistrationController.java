package com.notification.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notification.service.services.EmailService;
import com.notification.service.vo.WelcomeMailVO;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value="/welcome",method=RequestMethod.POST)
	public ResponseEntity<Object> welcome(@RequestBody WelcomeMailVO welcomeMailVO){
		return emailService.sendMail(welcomeMailVO);
	}

}
