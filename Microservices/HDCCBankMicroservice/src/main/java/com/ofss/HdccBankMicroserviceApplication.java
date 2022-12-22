package com.ofss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HdccBankMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdccBankMicroserviceApplication.class, args);
		System.out.println("HDCC service started...");
	}

}
