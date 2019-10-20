package com.cusd80.c3.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
public class C3ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(C3ServerApplication.class, args);
	}

}
