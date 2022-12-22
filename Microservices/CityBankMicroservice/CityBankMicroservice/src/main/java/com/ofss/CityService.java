package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	CityRepository cr;
	@Autowired
	RemoteRepository r;
	@Autowired
	RemoteInfinityRepository infy;
	
	public List<CityBank> getAllCustomers() {
		
		Iterable<CityBank> customers=cr.findAll();
		List<CityBank> allCustomers=new ArrayList<>();
		for (CityBank cust:customers)
		{
			allCustomers.add(cust);
		}
		return allCustomers;
	}

	public String viewCustomerByid(long accountNo) {
		Iterable<CityBank> customers=cr.findAll();
		for (CityBank c:customers)
		{
			if (c.getAccountNo()==accountNo)
			{
				return "The account details are :<br>"+c;
			}
		}
		return "Sorry!!!Bank account with this("+accountNo+") account number does not exist.";
		
	}

	public String addCustomer(CityBank cust) {
		String msg = "Caution! This EKYC already exists!!";
		Iterable<CityBank> custList=cr.findAll();
		for (CityBank c:custList) {
			if(c.getEkyc().equals(cust.getEkyc())) {
				
				return msg;
			}
		}
			if(r.getHdccCustomer(cust.getEkyc())!=null){
			cr.save(cust);
			System.out.println("saved..");
			msg = "EKYC VERIFIED FROM HDCC BANK! ACCOUNT CREATED SUCCESSFULLY!";
		}
			else if(infy.getInfinityCustomer(cust.getEkyc())!=null){
			cr.save(cust);
			System.out.println("saved..");
			msg = "EKYC VERIFIED FROM INFINITY BANK! ACCOUNT CREATED SUCCESSFULLY!";
		}
			else msg = "EKYC VERIFICATION FAILED! SORRY, YOUR ACCOUNT COULDN'T BE CREATED.";
		return msg;
	}

	public String getTotalBalance(String ekyc) {
		double balance1=0, balance2=0, balance3=0; 
		String msg = "Customer not found!";
		Iterable<CityBank> custList=cr.findAll();
		for (CityBank c:custList) {
			if(c.getEkyc().equals(ekyc)) {
				balance1=balance1+c.getAccountBalance();
				break;
			}else return msg;

		}
			if(infy.getInfinityCustomer(ekyc)!=null && r.getHdccCustomer(ekyc)!=null) {
				balance2=balance2+r.getHdccCustomer(ekyc).getAccountBalance();
				balance3=balance3+infy.getInfinityCustomer(ekyc).getAccountBalance();
				msg = "Balance amount in City bank account is Rs "+balance1+
						".<br>Balance amount in HDCC bank account is Rs "+balance2+
						".<br>Balance amount in Infinity bank account is Rs "+balance3+
						".<br><br>Aggregated Balance amount is Rs "+(balance1+balance2+balance3)+".";
			}
		
			else if(r.getHdccCustomer(ekyc)!=null ) {
			balance2=balance2+r.getHdccCustomer(ekyc).getAccountBalance();
			msg = "Balance amount in City bank account is Rs"+balance1+
					".<br>Balance amount in HDCC bank account is Rs"+balance2+
					".<br>Aggregated Balance amount is Rs"+(balance1+balance2)+".";
		}
			else if(infy.getInfinityCustomer(ekyc)!=null ) {
				balance3=balance3+infy.getInfinityCustomer(ekyc).getAccountBalance();
				msg = "Balance amount in City bank account is Rs"+balance1+
						".<br>Balance amount in Infinity bank account is Rs"+balance3+
						".<br>Aggregated Balance amount is Rs"+(balance1+balance3)+".";
			}
		
			
			
		return msg;
	}
	

}
