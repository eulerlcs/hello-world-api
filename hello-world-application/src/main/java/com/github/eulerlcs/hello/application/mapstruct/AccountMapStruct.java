package com.github.eulerlcs.hello.application.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.github.eulerlcs.hello.api.model.AccountModel;
import com.github.eulerlcs.hello.domain.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapStruct {
	Account modelToDomain(AccountModel account);

	List<Account> modelToDomain(List<AccountModel> accountList);

	AccountModel domainToModel(Account account);

	List<AccountModel> domainToModel(List<Account> account);
}
