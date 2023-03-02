package com.springBoot.mapping.service;

import java.util.List;

import com.springBoot.mapping.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	 
	 List<Customer> getAllCustomer();
	 
	 Customer getCustomerById(int id);
	 
	 int updateCustById(int id,Customer customer);
	 
	 String deleteById(int id);
	

}
