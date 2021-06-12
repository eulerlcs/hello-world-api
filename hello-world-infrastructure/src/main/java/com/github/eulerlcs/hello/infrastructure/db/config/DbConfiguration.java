package com.github.eulerlcs.hello.infrastructure.db.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.eulerlcs.hello.infrastructure.db.mapper")
public class DbConfiguration {

}
