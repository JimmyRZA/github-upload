package com.banking.system.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.banking.system.domain.Currency_Conversion_Rate;


public interface CurrencyCoversionRepository extends CrudRepository<Currency_Conversion_Rate, String>	{
	
	@Override
	public Optional<Currency_Conversion_Rate> findById(String id);

}
