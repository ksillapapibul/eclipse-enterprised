package com.hellospringboot.hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hellospringboot.hello.modellab.BankAccount;

@Configuration
	@Profile("development")
	public class DevConfig {

	   @Bean
	   public BankAccount bankAccount() {
		   System.out.println("This is a test in bank account");
	       return new BankAccount();
	   }

	}


