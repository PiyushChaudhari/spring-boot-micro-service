package com.account.create.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.create.dao.UserDao;
import com.account.create.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	public User save(User user) {
		log.info("save user:> {} ",user);
		return userDao.save(user);
	}

}
