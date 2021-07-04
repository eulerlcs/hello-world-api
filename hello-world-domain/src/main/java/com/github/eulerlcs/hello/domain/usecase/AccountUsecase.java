package com.github.eulerlcs.hello.domain.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.eulerlcs.hello.domain.entity.Account;
import com.github.eulerlcs.hello.domain.repository.AccountRepository;

@Transactional
@Service
public class AccountUsecase {

	@Autowired
	private AccountRepository repository;

	public Account selectOne(Integer id) {
		return repository.selectOne(id);
	}

	public List<Account> selectAll() {
		return repository.selectAll();
	}

	public int add(Account user) {
		return repository.add(user);
	}
}
