package com.github.eulerlcs.hello.api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.eulerlcs.hello.domain.domain.User;
import com.github.eulerlcs.hello.domain.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

// @Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping({ "/v1/user/add" })
	public User addUser(User user) {
		user.setCreated_at(LocalDateTime.now());
		userService.add(user);

		return user;
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

	@PostMapping({ "/v1/user/date" })
	@ApiOperation(value = "日付移送の確認", nickname = "testDate", notes = "日時をそのままで返す", response = String.class)
	public Date testDate(
			@ApiParam(value = "現在日付", example = "2021-06-19T19:34:56") @RequestParam(value = "date", required = false) Date date) {
		return date;
	}

	@PostMapping({ "/v1/user/localdate" })
	@ApiOperation(value = "日付移送の確認", nickname = "testLocalDate", notes = "ローカル日付をそのままで返す", response = String.class)
	public LocalDate testLocalDate(
			@ApiParam(value = "現在日付", example = "2021-06-19") @DateTimeFormat(iso = ISO.DATE) @RequestParam(value = "date", required = false) LocalDate date) {
		return date;
	}

	@PostMapping({ "/v1/user/localdatetime" })
	@ApiOperation(value = "日時移送の確認", nickname = "testLocalDateTime", notes = "ローカル日時をそのままで返す", response = String.class)
	public LocalDateTime testLocalDateTime(
			@ApiParam(value = "現在日時", example = "2021-06-26T19:34:56") @DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam(value = "datetime", required = false) LocalDateTime datetime) {
		return datetime;
	}

}
