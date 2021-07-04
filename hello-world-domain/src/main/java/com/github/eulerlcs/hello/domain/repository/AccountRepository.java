package com.github.eulerlcs.hello.domain.repository;

import java.util.List;

import com.github.eulerlcs.hello.domain.entity.Account;

public interface AccountRepository {
	List<Account> selectAll();
	Account selectOne(Integer id);
	int add(Account user);
}