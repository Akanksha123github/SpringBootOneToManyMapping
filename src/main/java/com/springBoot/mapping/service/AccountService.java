package com.springBoot.mapping.service;

import java.util.List;

import com.springBoot.mapping.entity.Account;


public interface AccountService{
	
	 Account saveAcc(Account account);
	 
	 List<Account> getAllAcc();
	 
	 Account getById(int id);
	 
	 int updateById(int id,Account account);
	 
	 String deleteAccById(int id);
	
}
