package com.crm.dao.customerCare;

public class CustomerCareFactory {

	private CustomerCareFactory(){
		
	}
	
	public static CustomerCareDao getInstance(){
		
		return new CustomerCareDaoImpl();
	}
}
