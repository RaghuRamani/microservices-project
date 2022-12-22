package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HdccCustomerService {
	
	@Autowired
	HDCCRepository hr;
	
	public void addCustomer(HDCCBank cust)
	{
		System.out.println("Adding customer object using CustomeRepository");
		hr.save(cust);
		System.out.println("Successfully added");
	}
	
	public List<HDCCBank> getAllCustomers()
	{
		Iterable<HDCCBank> custList=hr.findAll();
		List<HDCCBank> allCustomers=new ArrayList<>();
		for (HDCCBank c:custList)
		{
			allCustomers.add(c);
		}
		return allCustomers;
	}
	
	public HDCCBank getCustomerbyekyc(String ekyc) {
		Iterable<HDCCBank>custList=hr.findAll();
		for(HDCCBank c:custList) {
			if(c.getEkyc().equals(ekyc)) {
				return c;
			}	
	}
		return null;
	}
	



}
