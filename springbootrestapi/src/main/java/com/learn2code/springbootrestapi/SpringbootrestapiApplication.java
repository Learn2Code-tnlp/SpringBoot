package com.learn2code.springbootrestapi;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapiApplication.class, args);
	}


	// Customizing Swagger docs using Docket Spring bean
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2) // create an instance of docket which is configured to use swagger2
				.select()
				.paths(PathSelectors.ant("/api/**")) // docs are displayed only for this url paths
				.apis(RequestHandlerSelectors.basePackage("com.learn2code")) // packages that swagger need to look at, which excludes the models and extra generic info
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Employee API",
				"Sample API for SpringBoot Swagger tutorial",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Prasanna", "https://google.com", "a@bbc.com"),
				"API License",
				"https://google.com",
				Collections.emptyList());
	}

}
