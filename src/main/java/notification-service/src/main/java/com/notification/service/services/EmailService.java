package com.notification.service.services;

import org.springframework.http.ResponseEntity;

import com.notification.service.vo.WelcomeMailVO;

public interface EmailService {

	public ResponseEntity<Object> sendMail(WelcomeMailVO welcomeMailVO);
}
