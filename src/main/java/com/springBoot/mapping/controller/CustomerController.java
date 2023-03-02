package com.springBoot.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.mapping.entity.Account;
import com.springBoot.mapping.entity.Customer;
import com.springBoot.mapping.service.AccountService;
import com.springBoot.mapping.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		Customer addCustomer = customerService.addCustomer(customer);
		return addCustomer;
	}
	
	@GetMapping("getAllCust")
	public List<Customer> getAllCust() {
		List<Customer> allCustomer = customerService.getAllCustomer();
		return allCustomer;
		
	}
	
	@GetMapping("/getcustId/{id}")
	public Customer getCustById(@PathVariable int  id) {
		Customer customerById = customerService.getCustomerById(id);
		return customerById;
	}
	
	@PutMapping("/updateCust")
	public String updateCustomer(@RequestBody Customer customer) {
		
		int updateCustById = customerService.updateCustById(customer.getId(),customer);
		if(updateCustById ==0) {
			return "Id Is Not Present";
		}
		return String.format("Update Id Is %d", updateCustById) ;	
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteByIdCust(@PathVariable int  id) {
		return customerService.deleteById(id);
	}
	
	@PostMapping("/saveAcc")
	public Account saveAccount(@RequestBody Account account) {
		Account saveAcc = accountService.saveAcc(account);
		return saveAcc;
	}
	
	@GetMapping("/getAllAcc")
	public List<Account> getAllAcc(){
		List<Account> allAcc = accountService.getAllAcc();
		return allAcc;
	}
	
	@GetMapping("/{id}")
	public Account getAccById(@PathVariable int  id) {
		Account byId = accountService.getById(id);
		return byId;
	}
	
	@PutMapping("/updateAcc")
	public String updateAcc(@RequestBody Account account) {
		int byId = accountService.updateById(account.getAccId(), account);
		if(byId == 0) {
			return "Account No Is Not Present";
		}
		return String.format("Account is %d", byId );
		
	}
	
	@DeleteMapping("/deleteAcc")
	public String deleteAcc(int id) {
		return accountService.deleteAccById(id);
	}

	
	
	

}
