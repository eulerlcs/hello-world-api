package com.github.eulerlcs.hello.domain.repository;

import java.util.List;

import com.github.eulerlcs.hello.domain.entity.User;

public interface UserRepository {
	List<User> selectAll();
	User selectOne(Integer id);
	int add(User user);
}