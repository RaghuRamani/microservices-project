package com.ofss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteRepository {
	
	@Autowired
	protected  RestTemplate restTemplate;
	protected  String hdccServiceUrl;
	
	public RemoteRepository(String hdccServiceUrl) {
		// TODO Auto-generated constructor stub
		this.hdccServiceUrl = hdccServiceUrl.startsWith("http") ? hdccServiceUrl
				: "http://" + hdccServiceUrl;
		System.out.println("the generated url: "+this.hdccServiceUrl);
	}
	
	public HDCCBank getHdccCustomer(String ekyc) {
		System.out.println("serviceUrl is "+hdccServiceUrl + "/customers/{ekyc}");
		
		return restTemplate.getForObject(hdccServiceUrl + "/customers/{ekyc}",
				HDCCBank.class, ekyc);
	}
}
