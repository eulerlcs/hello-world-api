package com.github.eulerlcs.hello.domain.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class User {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private String name;
	private String department;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
}
