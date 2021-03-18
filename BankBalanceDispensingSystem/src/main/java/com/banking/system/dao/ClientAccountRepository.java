package com.banking.system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.banking.system.domain.Client_Account;

public interface ClientAccountRepository extends CrudRepository<Client_Account, String> {
	
	@Override
	public List<Client_Account> findAll();
	
	
	@Override
	public Optional<Client_Account> findById(String id);

}
