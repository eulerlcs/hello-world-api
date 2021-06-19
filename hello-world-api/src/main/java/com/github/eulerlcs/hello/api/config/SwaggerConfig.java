package com.github.eulerlcs.hello.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig implements WebMvcConfigurer {
	@Value("${springfox.documentation.enabled: true}")
	private boolean springfoxDocumentationEnabled;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).enable(springfoxDocumentationEnabled).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.github.eulerlcs.hello"))
				.paths(PathSelectors.regex("/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("POC").description("XXX platform interface").license("").licenseUrl("")
				.termsOfServiceUrl("").version("1.0.0").contact(new Contact("", "", "")).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
