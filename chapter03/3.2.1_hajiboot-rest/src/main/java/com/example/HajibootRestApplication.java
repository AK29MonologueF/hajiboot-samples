package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HajibootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HajibootRestApplication.class, args);
	}
	
	//http://localhost:8080/api/customers -i -XPOST -H "Content-Type: application/json" -d "{\"firstName\":\"tamako\", \"lastName\":\"Nobi\"}"
	
}