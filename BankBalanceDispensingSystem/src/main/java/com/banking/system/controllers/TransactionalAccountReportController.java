package com.banking.system.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.system.domain.TransactionalAccountReportBean;
import com.banking.system.service.ReportsService;

@RequestMapping("/reports")
@Controller
public class TransactionalAccountReportController {

	//TODO get the maven dependecy for jhipster
	//@Value("${jhipster.clientApp.name}")
	private String applicationName;
	
	ReportsService  reportsService;

	@Autowired
	TransactionalAccountReportBean transactionalAccountReportBean;

	@GetMapping("/transactional-accounts-report/{type}")
	public ResponseEntity<Resource> displayClientsAccounts(Model model, @PathVariable String type) throws IOException {
		String contentType = null;

		Resource resource = reportsService.exportAll(type);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.contentLength(resource.getFile().length())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resource.getFilename())
				.headers(createAlert(applicationName, "transactions accounts exported successfully", resource.toString()))
				.body(resource);

	}
	
	@GetMapping("/aggregate-financials-report/{type}")
	public ResponseEntity<Resource> displayAggregateFinancials(Model model, @PathVariable String type) throws IOException {
		String contentType = null;

		Resource resource = reportsService.exportAggregateAll(type);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.contentLength(resource.getFile().length())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + resource.getFilename())
				.headers(createAlert(applicationName, "transactions accounts exported successfully", resource.toString()))
				.body(resource);

	}
	
	
	
	public HttpHeaders createAlert(String applicationName, String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + applicationName + "-alert", message);
        headers.add("X-" + applicationName + "-params", param);
        return headers;
    }

}
