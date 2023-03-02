package com.springBoot.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.mapping.entity.Account;
import com.springBoot.mapping.entity.Customer;
import com.springBoot.mapping.repository.AccountRepository;
import com.springBoot.mapping.repository.CustomerRepository;


@Service
public class CostomerServiceImpl implements CustomerService,AccountService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		Customer save = customerRepository.save(customer);
		return save;
	}

	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> findAll = customerRepository.findAll();
		return findAll;
	}
	

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> findById = customerRepository.findById(id);
		return findById.isPresent()?findById.get():null;
	}
	

	@Override
	public int updateCustById(int id, Customer customer) {
		Optional<Customer> byId = customerRepository.findById(id);
		if(byId.isPresent()) {
			Customer save = customerRepository.save(customer);
			return save.getId();
		}
		return 0;
	}

	@Override
	public String deleteById(int id) {
		customerRepository.deleteById(id);
		return "Deleted Successfully Id";
	}


	@Override
	public Account saveAcc(Account account) {
		Account save = accountRepository.save(account);
		return save;
	}

	@Override
	public List<Account> getAllAcc() {
		List<Account> findAll = accountRepository.findAll();
		return findAll;
	}


	@Override
	public Account getById(int id) {
		Optional<Account> findById = accountRepository.findById(id);
		return findById.isPresent()?findById.get():null;
	}


	@Override
	public int updateById(int id, Account account) {
	    Optional<Account> optional = accountRepository.findById(id);
	    if(optional.isPresent()) {
	    Account save = accountRepository.save(account);
	    return  save.getAccId();
	    }
		return 0;
	}


	@Override
	public String deleteAccById(int id) {
		accountRepository.deleteById(id);
		return "Delete Id Successfully";
	}

}
