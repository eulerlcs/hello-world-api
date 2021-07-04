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

import com.github.eulerlcs.hello.api.face.AccountApi;
import com.github.eulerlcs.hello.api.model.AccountModel;
import com.github.eulerlcs.hello.application.mapstruct.AccountMapStruct;
import com.github.eulerlcs.hello.domain.entity.Account;
import com.github.eulerlcs.hello.domain.usecase.AccountUsecase;

// @Slf4j
@RestController
@RequestMapping("/api")
public class AccountController implements AccountApi {
	@Autowired
	private AccountMapStruct accountMapStruct;
	@Autowired
	private AccountUsecase accountUsecase;

	@Override
	@PostMapping({ "/v1/account/add" })
	public AccountModel addAccount(AccountModel accountModel) {
		Account account = accountMapStruct.modelToDomain(accountModel);
		account.setCreated_at(LocalDateTime.now());
		accountUsecase.add(account);

		return accountMapStruct.domainToModel(account);
	}

	@Override
	@GetMapping({ "/v1/account", "/v1/account/list" })
	public List<AccountModel> selectAll() {
		List<Account> accountList = accountUsecase.selectAll();

		return accountMapStruct.domainToModel(accountList);
	}

	@Override
	@GetMapping("/v1/account/{id}")
	public AccountModel detail(@PathVariable Integer id) {
		Account account = accountUsecase.selectOne(id);

		return accountMapStruct.domainToModel(account);
	}

	@Override
	@PostMapping({ "/v1/account/date" })
	public Date testDate(Date date) {
		return date;
	}

	@Override
	@PostMapping({ "/v1/account/localdate" })
	public LocalDate testLocalDate(LocalDate date) {
		return date;
	}

	@Override
	@PostMapping({ "/v1/account/localdatetime" })
	public LocalDateTime testLocalDateTime(LocalDateTime datetime) {
		return datetime;
	}

}
