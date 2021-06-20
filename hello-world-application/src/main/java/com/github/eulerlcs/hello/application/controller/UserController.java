package com.github.eulerlcs.hello.application.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.eulerlcs.hello.api.face.UserApi;
import com.github.eulerlcs.hello.api.model.UserModel;
import com.github.eulerlcs.hello.application.mapstruct.UserMapStruct;
import com.github.eulerlcs.hello.domain.entity.User;
import com.github.eulerlcs.hello.domain.usecase.UserUsecase;

// @Slf4j
@RestController
@RequestMapping("/api")
public class UserController implements UserApi {
	@Autowired
	private UserMapStruct userMapStruct;
	@Autowired
	private UserUsecase userUsecase;

	@Override
	@PostMapping({ "/v1/user/add" })
	public UserModel addUser(UserModel userModel) {
		User user = userMapStruct.modelToDomain(userModel);
		user.setCreated_at(LocalDateTime.now());
		userUsecase.add(user);

		return userMapStruct.domainToModel(user);
	}

	@Override
	@GetMapping({ "/v1/user", "/v1/user/list" })
	public List<UserModel> selectAll() {
		List<User> userList = userUsecase.selectAll();

		return userMapStruct.domainToModel(userList);
	}

	@Override
	@GetMapping("/v1/user/{id}")
	public UserModel detail(@PathVariable Integer id) {
		User user = userUsecase.selectOne(id);

		return userMapStruct.domainToModel(user);
	}

	@Override
	@PostMapping({ "/v1/user/date" })
	public Date testDate(Date date) {
		return date;
	}

	@Override
	@PostMapping({ "/v1/user/localdate" })
	public LocalDate testLocalDate(LocalDate date) {
		return date;
	}

	@Override
	@PostMapping({ "/v1/user/localdatetime" })
	public LocalDateTime testLocalDateTime(LocalDateTime datetime) {
		return datetime;
	}

}
