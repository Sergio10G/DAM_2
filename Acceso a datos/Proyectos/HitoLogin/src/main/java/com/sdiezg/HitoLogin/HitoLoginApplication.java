package com.sdiezg.HitoLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sdiezg.HitoLogin.model.User;

@SpringBootApplication
public class HitoLoginApplication {
	
	public static User loggedUser = null;

	public static void main(String[] args) {
		SpringApplication.run(HitoLoginApplication.class, args);
	}

}
