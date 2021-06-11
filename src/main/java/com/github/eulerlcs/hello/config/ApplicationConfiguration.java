package com.github.eulerlcs.hello.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.eulerlcs.hello.mapper")
public class ApplicationConfiguration {

}
