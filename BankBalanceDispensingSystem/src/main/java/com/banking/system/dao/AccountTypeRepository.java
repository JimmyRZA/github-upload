package com.banking.system.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.banking.system.domain.Account_Type;

public interface AccountTypeRepository extends CrudRepository<Account_Type, String>	{
	
	@Override
	public Optional<Account_Type> findById(String id);

}
