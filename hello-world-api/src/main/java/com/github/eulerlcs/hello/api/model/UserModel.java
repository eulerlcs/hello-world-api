package com.github.eulerlcs.hello.api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserModel {
	@ApiModelProperty(position = 1, example = "null", required = false, hidden = true, value = "ユーザID")
	private Integer id;
	@ApiModelProperty(position = 2, example = "田中　一郎", value = "ユーザ名")
	private String name;
	@ApiModelProperty(position = 3, example = "開発部", value = "所属")
	private String department;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@ApiModelProperty(position = 4, example = "2021-06-20T00:04:53", required = false, value = "作成日時")
	private LocalDateTime created_at;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@ApiModelProperty(position = 5, example = "2021-06-20T00:05:12", hidden = true, required = false, value = "更新日時")
	@JsonIgnore
	private LocalDateTime updated_at;
}
