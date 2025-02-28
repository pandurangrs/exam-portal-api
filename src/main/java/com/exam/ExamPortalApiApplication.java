package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value="classpath:/profiles/${spring.profiles.active}/application.properties")
public class ExamPortalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApiApplication.class, args);
		System.out.println("Hello exam protal");
	}

}
