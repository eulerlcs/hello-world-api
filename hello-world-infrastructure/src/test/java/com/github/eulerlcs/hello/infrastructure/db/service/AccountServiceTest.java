package com.github.eulerlcs.hello.infrastructure.db.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.eulerlcs.hello.domain.entity.Account;
import com.github.eulerlcs.hello.domain.repository.AccountRepository;

@SpringBootTest
class AccountServiceTest {
	@Autowired
	private AccountRepository userService;

	@Test
	void testSelectUser() {
		Account user = userService.selectOne(2);
		assertEquals(2, user.getId());
		assertEquals("ws-001", user.getName());
		assertEquals("department 1", user.getDepartment());
	}
}
