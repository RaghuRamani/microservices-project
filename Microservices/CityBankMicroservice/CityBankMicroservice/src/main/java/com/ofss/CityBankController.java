package com.ofss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityBankController {
	
	@Autowired
	CityService cs;
	
	//get all customers' details
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<CityBank> getAll(){
		return cs.getAllCustomers();
	}
	
	//get account details 
	@RequestMapping(value="/customers/{accountNo}",method=RequestMethod.GET)
	public String getCustomer(@PathVariable(value="accountNo") long accountNo)
	{
		
		return cs.viewCustomerByid(accountNo);
		
	}
	
	//Add account after ekyc verification
	@RequestMapping(value="/customers/add",method=RequestMethod.POST)
	public String add(@RequestBody CityBank cust) {
		
		return cs.addCustomer(cust);
	}
	
	//show aggregated balance
	@RequestMapping(value="/customers/{ekyc}/balance",method=RequestMethod.GET)
	public String getBalance(@PathVariable("ekyc") String ekyc) 
	{	
		return cs.getTotalBalance(ekyc);
	}
	
	
	

}
