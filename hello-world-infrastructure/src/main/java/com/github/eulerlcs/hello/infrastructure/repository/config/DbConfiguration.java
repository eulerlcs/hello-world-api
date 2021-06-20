package com.github.eulerlcs.hello.infrastructure.repository.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.eulerlcs.hello.infrastructure.repository.mapper")
public class DbConfiguration {

}
