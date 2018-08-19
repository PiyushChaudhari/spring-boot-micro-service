package com.account.create.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.create.model.User;

public interface UserDao extends JpaRepository<User,Long>{

}
