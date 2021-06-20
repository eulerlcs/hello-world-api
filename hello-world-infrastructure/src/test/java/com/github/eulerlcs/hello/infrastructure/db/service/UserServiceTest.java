package com.github.eulerlcs.hello.infrastructure.db.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.eulerlcs.hello.domain.entity.User;
import com.github.eulerlcs.hello.domain.repository.UserRepository;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserRepository userService;

	@Test
	void testSelectUser() {
		User user = userService.selectOne(2);
		assertEquals(2, user.getId());
		assertEquals("ws-001", user.getName());
		assertEquals("department 1", user.getDepartment());
	}
}
