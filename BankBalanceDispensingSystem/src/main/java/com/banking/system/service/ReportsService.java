package com.banking.system.service;

import org.springframework.core.io.Resource;

public interface ReportsService {
	
	public Resource exportAll(String type);
	
	public Resource exportAggregateAll(String type);

}