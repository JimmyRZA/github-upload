package com.banking.system.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.banking.system.dao.ClientAccountRepository;
import com.banking.system.domain.Client_Account;
import com.banking.system.domain.SimpleReportExporter;
import com.banking.system.domain.TransactionalAccountReportBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;
//TODO Reports part not tested.

@Service
@Transactional
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	ClientAccountRepository clientAccountRepo;
	
	@Autowired
	TransactionalAccountReportBean transactionalAccountReportBean;
	
	private final Path fileStorageLocation;
	
	public ReportsServiceImpl() {
		this.fileStorageLocation = Paths.get("../Docs").toAbsolutePath().normalize();
	}

	@Override
	@Transactional(readOnly = true)
	public Resource exportAggregateAll(String type) {
		
		List<TransactionalAccountReportBean> transactionalAccountReportList = new ArrayList<TransactionalAccountReportBean>();
		
		try {
		File file = ResourceUtils.getFile("classpath:example.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRSaver.saveObject(jasperReport, "exampleReport.jasper");
		
		//TODO Aggregate accouts to be implemented
		//TODO to be implemented.
		
//		transactionalAccountReportBean = new TransactionalAccountReportBean();
//		
//		transactionalAccountReportBean.setClientAccountNumber(maximumBalanceAcc.getClientAccountNumber());
//		transactionalAccountReportBean.setClientId(String.valueOf(maximumBalanceAcc.getClientId()));
//		
////		transactionalAccountReportBean.setClientSurname(maximumBalanceAcc.get);
//		
//		transactionalAccountReportBean.setDisplayBalance(String.valueOf(maximumBalanceAcc.getDisplayBalance()));
//		
//		transactionalAccountReportList.add(transactionalAccountReportBean);
		
		
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactionalAccountReportList);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userName", "Dhaval's Orders");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		SimpleReportExporter simpleReportExporter = new SimpleReportExporter(jasperPrint);
		String fileName = "";
		switch (type) {
		case "PDF": 
		case "PRINT":
			fileName = "example.pdf";
//			JasperExportManager.exportReportToPdfFile(jasperPrint, this.fileStorageLocation + "/example.pdf");
			simpleReportExporter.exportToPdf(this.fileStorageLocation + "/" + fileName, "DHAVAL");
			break;
		case "XLSX":
			fileName = "Example.xlsx";
			simpleReportExporter.exportToXlsx(this.fileStorageLocation + "/" + fileName, "Example");
			break;
		case "CSV":
			fileName = "example.csv";
			simpleReportExporter.exportToCsv(this.fileStorageLocation + "/" + fileName);
			break;
		default:
			break;
		}
		return loadFileAsResource(fileName);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//TODO Reports part not tested.
	@Override
	@Transactional(readOnly = true)
	public Resource exportAll(String type) {
		
		List<TransactionalAccountReportBean> transactionalAccountReportList = new ArrayList<TransactionalAccountReportBean>();
		
		try {
		File file = ResourceUtils.getFile("classpath:example.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRSaver.saveObject(jasperReport, "exampleReport.jasper");
		
		Comparator<Client_Account> comparator = Comparator.comparing(Client_Account::getDisplayBalance);
		
		Client_Account maximumBalanceAcc = clientAccountRepo.findAll().stream().max(comparator).get();
		
		transactionalAccountReportBean = new TransactionalAccountReportBean();
		
		transactionalAccountReportBean.setClientAccountNumber(maximumBalanceAcc.getClientAccountNumber());
		transactionalAccountReportBean.setClientId(String.valueOf(maximumBalanceAcc.getClientId()));
		
//		transactionalAccountReportBean.setClientSurname(maximumBalanceAcc.get);
		
		transactionalAccountReportBean.setDisplayBalance(String.valueOf(maximumBalanceAcc.getDisplayBalance()));
		
		transactionalAccountReportList.add(transactionalAccountReportBean);
		
		
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(transactionalAccountReportList);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("userName", "Dhaval's Orders");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		SimpleReportExporter simpleReportExporter = new SimpleReportExporter(jasperPrint);
		String fileName = "";
		switch (type) {
		case "PDF": 
		case "PRINT":
			fileName = "example.pdf";
//			JasperExportManager.exportReportToPdfFile(jasperPrint, this.fileStorageLocation + "/example.pdf");
			simpleReportExporter.exportToPdf(this.fileStorageLocation + "/" + fileName, "DHAVAL");
			break;
		case "XLSX":
			fileName = "Example.xlsx";
			simpleReportExporter.exportToXlsx(this.fileStorageLocation + "/" + fileName, "Example");
			break;
		case "CSV":
			fileName = "example.csv";
			simpleReportExporter.exportToCsv(this.fileStorageLocation + "/" + fileName);
			break;
		default:
			break;
		}
		return loadFileAsResource(fileName);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private Resource loadFileAsResource(String fileName) throws IOException {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new FileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new FileNotFoundException("File not found " + fileName);
		}
	}
	

}