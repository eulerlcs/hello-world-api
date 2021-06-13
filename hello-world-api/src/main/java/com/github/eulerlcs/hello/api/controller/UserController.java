package com.github.eulerlcs.hello.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.eulerlcs.hello.domain.domain.User;
import com.github.eulerlcs.hello.domain.service.UserService;

// @Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

	@PutMapping({"/v1/user/add" })
	public int addUser(@ModelAttribute("user") User user) {
		return userService.add(user);
	}

	@GetMapping({ "/v1/user", "/v1/user/list" })
	public List<User> selectAll() {
		List<User> userList = userService.selectAll();

		return userList;
	}
	@GetMapping("/v1/user/{id}")
	public User detail(@PathVariable Integer id) {
		User user = userService.selectOne(id);

		return user;
	}
}
