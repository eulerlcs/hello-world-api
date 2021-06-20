package com.github.eulerlcs.hello.application.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.github.eulerlcs.hello.api.model.UserModel;
import com.github.eulerlcs.hello.domain.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
	User modelToDomain(UserModel user);

	List<User> modelToDomain(List<UserModel> userList);

	UserModel domainToModel(User user);

	List<UserModel> domainToModel(List<User> user);
}
