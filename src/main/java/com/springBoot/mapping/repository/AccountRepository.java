package com.springBoot.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.mapping.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{


}
