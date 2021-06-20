package com.github.eulerlcs.hello.api.face;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.eulerlcs.hello.api.model.UserModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "user")
public interface UserApi {

	@ApiOperation(value = "ユーザ追加", nickname = "addUser", notes = "ユーザを新規する", response = String.class)
	UserModel addUser(UserModel user);

	@ApiOperation(value = "すべてユーザの取得", nickname = "selectAll", notes = "すべてのユーザを取得する", response = String.class)
	List<UserModel> selectAll();

	@ApiOperation(value = "個別ユーザの取得", nickname = "detail", notes = "個別ユーザを取得する", response = String.class)
	UserModel detail(Integer id);

	@ApiOperation(value = "日付移送の確認", nickname = "testDate", notes = "日時をそのままで返す", response = String.class)
	Date testDate(
			@ApiParam(value = "現在日付", example = "2021-06-19T19:34:56") @RequestParam(value = "date", required = false) Date date);

	@ApiOperation(value = "ローカル日付移送の確認", nickname = "testLocalDate", notes = "ローカル日付をそのままで返す", response = String.class)
	LocalDate testLocalDate(
			@ApiParam(value = "現在日付", example = "2021-06-19") @DateTimeFormat(iso = ISO.DATE) @RequestParam(value = "date", required = false) LocalDate date);

	@ApiOperation(value = "日時移送の確認", nickname = "testLocalDateTime", notes = "ローカル日時をそのままで返す", response = String.class)
	LocalDateTime testLocalDateTime(
			@ApiParam(value = "現在日時", example = "2021-06-26T19:34:56") @DateTimeFormat(iso = ISO.DATE_TIME) @RequestParam(value = "datetime", required = false) LocalDateTime datetime);

}