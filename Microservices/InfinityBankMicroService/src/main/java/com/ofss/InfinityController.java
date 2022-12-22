
package com.ofss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InfinityController {
	
	@Autowired
	InfinityCustomerService hs;
	
	@RequestMapping(value="/customers/add", method=RequestMethod.POST)
	public void add(@RequestBody InfinityBank cust) {
		hs.addCustomer(cust);
	}
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<InfinityBank> m1(){
		System.out.println("Inside m1 method..");
		
		return hs.getAllCustomers();
	}
	@RequestMapping(value="/customers/{ekyc}", method=RequestMethod.GET)
	public InfinityBank getCustomer(@PathVariable("ekyc") String ekyc) {
		return hs.getCustomerbyekyc(ekyc);
	}
}
