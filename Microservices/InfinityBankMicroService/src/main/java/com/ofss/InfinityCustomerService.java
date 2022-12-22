
package com.ofss;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class InfinityCustomerService {
	
	@Autowired
	InfinityRepository hr;
	
	public void addCustomer(InfinityBank cust)
	{
		System.out.println("Adding customer object using CustomeRepository");
		hr.save(cust);
		System.out.println("Successfully added");
	}
	
	public List<InfinityBank> getAllCustomers()
	{
		Iterable<InfinityBank> custList=hr.findAll();
		List<InfinityBank> allCustomers=new ArrayList<>();
		for (InfinityBank c:custList)
		{
			allCustomers.add(c);
		}
		return allCustomers;
	}

	public InfinityBank getCustomerbyekyc(String ekyc) {
		Iterable<InfinityBank>custList=hr.findAll();
		for(InfinityBank c:custList) {
			if(c.getEkyc().equals(ekyc)) {
				return c;
			}	
	}
		return null;
	}
}
