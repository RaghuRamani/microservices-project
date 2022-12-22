package com.ofss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CityBankMicroserviceApplication {
	
	public final String HDCC_SERVICE_URL="http://hdccbank-microservice";
	public final String INFINITY_SERVICE_URL="http://infinitybank-microservice";
	
			
		public static void main(String[] args) {
		SpringApplication.run(CityBankMicroserviceApplication.class, args);
		System.out.println("City Bank service started .....");
		
		}
		
		@Bean
		public RemoteRepository remoteRepository()
		{
			RemoteRepository r=new RemoteRepository(HDCC_SERVICE_URL);
			return r;
		}
		@Bean
		public RemoteInfinityRepository remoteInfyRepository()
		{
			RemoteInfinityRepository infy=new RemoteInfinityRepository(INFINITY_SERVICE_URL);
			return infy;
		}
		
		@Bean
		@LoadBalanced
		public RestTemplate restTempate()
		{
			return new RestTemplate();
		}
		
		
	

}
