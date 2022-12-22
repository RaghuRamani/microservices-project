
package com.ofss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfinityBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinityBankApplication.class, args);
		System.out.println("Infinity service started...");
	}

}
