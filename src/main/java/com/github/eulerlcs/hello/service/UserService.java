package com.github.eulerlcs.hello.service;

import java.util.List;

import com.github.eulerlcs.hello.domain.User;

public interface UserService {
	List<User> selectAll();
	User selectOne(Integer id);
	int add(User user);
}