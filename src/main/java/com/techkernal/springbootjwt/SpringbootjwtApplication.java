package com.techkernal.springbootjwt;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjwtApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
