package com.meritamericabank.bank;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories //***not sure if needs parameters****
@SpringBootApplication //this enables auto config,componentscan which allows spring to look for other components, configs and services in the com/example package, letting it find controllers
public class BankApplication {

	private static final Logger Log = LoggerFactory.getLogger(BankApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	
	//todo: implement @bean to preload data to the database

}
