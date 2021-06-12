package com.github.eulerlcs.hello.infrastructure.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.eulerlcs.hello.domain.domain.User;
import com.github.eulerlcs.hello.domain.service.UserService;
import com.github.eulerlcs.hello.infrastructure.db.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public User selectOne(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectList(null);
	}

	@Override
	public int add(User user) {
		return userMapper.insert(user);
	}
}
