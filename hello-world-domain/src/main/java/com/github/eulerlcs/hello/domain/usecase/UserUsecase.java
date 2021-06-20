package com.github.eulerlcs.hello.domain.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.eulerlcs.hello.domain.entity.User;
import com.github.eulerlcs.hello.domain.repository.UserRepository;

@Transactional
@Service
public class UserUsecase {

	@Autowired
	private UserRepository repository;

	public User selectOne(Integer id) {
		return repository.selectOne(id);
	}

	public List<User> selectAll() {
		return repository.selectAll();
	}

	public int add(User user) {
		return repository.add(user);
	}
}
