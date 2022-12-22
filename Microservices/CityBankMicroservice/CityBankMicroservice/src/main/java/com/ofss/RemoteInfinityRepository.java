package com.ofss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteInfinityRepository {
	@Autowired
	protected  RestTemplate restTemplate;
	protected  String infyServiceUrl;
	
	public RemoteInfinityRepository(String infyServiceUrl) {
		// TODO Auto-generated constructor stub
		this.infyServiceUrl = infyServiceUrl.startsWith("http") ? infyServiceUrl
				: "http://" + infyServiceUrl;
		System.out.println("the generated url: "+this.infyServiceUrl);
	}
	
	public InfinityBank getInfinityCustomer(String ekyc) {
		System.out.println("serviceUrl is "+infyServiceUrl + "/customers/{ekyc}");
		
		return restTemplate.getForObject(infyServiceUrl + "/customers/{ekyc}",
				InfinityBank.class, ekyc);
	}
}
