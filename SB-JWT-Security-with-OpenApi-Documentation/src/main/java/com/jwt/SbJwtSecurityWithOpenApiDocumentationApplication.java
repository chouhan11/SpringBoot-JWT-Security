package com.jwt;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jwt.entity.User;
import com.jwt.repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "JWT Security API",version = "2.0",description = "POC for JWT Authentication and Authorization..!!"))
@SpringBootApplication
public class SbJwtSecurityWithOpenApiDocumentationApplication {

	@Autowired
	private UserRepository userRepo;

	@PostConstruct
	private void initUser() {
		List<User> users = Stream.of(
				new User(101, "Madhur", "1092", "abc@gmail.com"),
				new User(102, "sumit", "0097", "sumit@gmail.com"),
				new User(103, "amit", "00553", "amit@gmail.com"),
				new User(104, "addi", "94837", "addi@gmail.com"))
				.collect(Collectors.toList());
		 userRepo.saveAll(users);

		 

	}

	public static void main(String[] args) {
		SpringApplication.run(SbJwtSecurityWithOpenApiDocumentationApplication.class, args);
	}

}
