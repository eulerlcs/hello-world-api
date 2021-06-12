package com.github.eulerlcs.hello.domain.service;

import java.util.List;

import com.github.eulerlcs.hello.domain.domain.User;

public interface UserService {
	List<User> selectAll();
	User selectOne(Integer id);
	int add(User user);
}