package com.github.eulerlcs.hello.domain.domain;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
	@ApiModelProperty(example = "null", required = false, hidden = true, value = "ユーザID")
	@TableId(type = IdType.AUTO)
	private Integer id;
	@ApiModelProperty(example = "田中　一郎", value = "ユーザ名")
	private String name;
	@ApiModelProperty(example = "開発部", value = "所属")
	private String department;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonIgnore
	@ApiModelProperty(example = "2020-08-30T02:09:53", required = false, value = "作成日時")
	private LocalDateTime created_at;
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@ApiModelProperty(example = "2020-08-30T02:09:53", hidden = true, required = false, value = "更新日時")
	private LocalDateTime updated_at;
}
