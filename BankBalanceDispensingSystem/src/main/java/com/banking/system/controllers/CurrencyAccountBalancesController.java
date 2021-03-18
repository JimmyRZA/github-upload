package com.banking.system.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.banking.system.dao.ClientAccountRepository;
import com.banking.system.dao.CurrencyCoversionRepository;
import com.banking.system.domain.Client_Account;
import com.banking.system.domain.CurrencyAccountBalancesBean;
import com.banking.system.domain.Currency_Conversion_Rate;

/**
 * @author Jimmy Mhlanga
 *
 */
@Controller
@RequestMapping("/currency")
public class CurrencyAccountBalancesController {
	
	@Autowired
	ClientAccountRepository clientAccountRepo;
	
	@Autowired
	CurrencyCoversionRepository currencyConversionRepo;
	
	@Autowired
	CurrencyAccountBalancesBean currencyAccountBalancesBean;
	
	
	@GetMapping("/home")
	public String displayHomePage() {
		return "BankingHomePageLanding";
	}
	
	@RequestMapping("/account-balances")
	public String displayCurrencyAccountBalances(Model model) {
		
		List<CurrencyAccountBalancesBean> currencyAccountBalancesList = new ArrayList<CurrencyAccountBalancesBean>();
		
		List<Client_Account> accounts = clientAccountRepo.findAll().stream()
				.filter(account -> (!account.getCurrencyCode().equalsIgnoreCase("ZAR"))).collect(Collectors.toList());
		
		for(Client_Account acc : accounts) {
			Optional<Currency_Conversion_Rate> currRateDetails = currencyConversionRepo.findById(acc.getCurrencyCode());
			currencyAccountBalancesBean =  new CurrencyAccountBalancesBean();
			
			currencyAccountBalancesBean.setAccountNumber(acc.getClientAccountNumber());
			currencyAccountBalancesBean.setCurrency(acc.getCurrencyCode());
			currencyAccountBalancesBean.setCurrencyBalance(acc.getDisplayBalance());
			
			if(currRateDetails.isPresent()) {
				currencyAccountBalancesBean.setConversionRate(currRateDetails.get().getRate());
			}	
			currencyAccountBalancesBean.setZarAmount((currRateDetails.get().getRate() * acc.getDisplayBalance()));
			currencyAccountBalancesList.add(currencyAccountBalancesBean);
		}
		
		
		
		model.addAttribute("currencyAccountBalancesList", currencyAccountBalancesList);
		
		return "currency-account-balances";
	}
	

}
