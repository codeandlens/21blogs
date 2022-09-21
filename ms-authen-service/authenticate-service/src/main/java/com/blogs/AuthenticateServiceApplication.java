package com.blogs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.blogs.bao.AuthenBAO;

@SpringBootApplication
public class AuthenticateServiceApplication {
    
    	@Autowired
    	private AuthenBAO authenBao;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateServiceApplication.class, args);
	}
	
	@PostConstruct
	public void initMethod() {
	    	authenBao.checkingDataSubscripted();
	}

}
