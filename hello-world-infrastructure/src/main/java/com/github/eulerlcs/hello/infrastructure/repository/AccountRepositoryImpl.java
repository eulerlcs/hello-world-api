package com.github.eulerlcs.hello.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.eulerlcs.hello.domain.entity.Account;
import com.github.eulerlcs.hello.domain.repository.AccountRepository;
import com.github.eulerlcs.hello.infrastructure.repository.mapper.AccountMapper;

@Service
public class AccountRepositoryImpl implements AccountRepository {

	@Autowired
	AccountMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Account selectOne(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public List<Account> selectAll() {
		return userMapper.selectList(null);
	}

	@Override
	public int add(Account user) {
		return userMapper.insert(user);
	}
}
