package com.banking.system.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banking.system.dao.AccountTypeRepository;
import com.banking.system.dao.ClientAccountRepository;
import com.banking.system.domain.Account_Type;
import com.banking.system.domain.AmountDetails;
import com.banking.system.domain.Client_Account;

/**
 * @author Jimmy Mhlanga
 *
 */
@Controller
@RequestMapping("/transactional")
public class TransactionalAccountBalanceController {
	
	@Autowired
	private AmountDetails amount_Details;
	
	private float balance;
	
	@Autowired
	ClientAccountRepository clientAccountRepo;
		
	@Autowired
	AccountTypeRepository accountTypeRepo;
	
	@GetMapping("/home")
	public String displayHomePage() {
		return "BankingHomePageLanding";
	}
	
	@GetMapping("/account-balance")
	public String displayTransactionalAccountBalance(Model model) {
		List<Client_Account> accounts = clientAccountRepo.findAll().stream().sorted().collect(Collectors.toList());
	
		for(Client_Account acc : accounts) {
			Optional<Account_Type> accoutType = accountTypeRepo.findById(acc.getAccountTypeCode());
			if(accoutType.isPresent()) {
				acc.setAccountTypeCode(accoutType.get().getDescription());
			}			
		}
		
		model.addAttribute("transactionAccBal", accounts);
		
		return "transactional-account-balances";
	}
	
	@GetMapping("/withdraw")
	public String displayWithdraw(@RequestParam String accountNum, @RequestParam String accountType, Model model) {
		AmountDetails amountDetails = new AmountDetails();
		amountDetails.setAccountNumber(accountNum);
		amountDetails.setType(accountType);
		amountDetails.setAmount(0);
		amount_Details = new AmountDetails(accountNum, accountType, 0);
		model.addAttribute("amountDetails", amountDetails);
		return "withdraw-money";
		
	}
	
	@PostMapping("/dowithdraw")
	public String doWithDrawal(AmountDetails amountDetails, Model model) {
		amountDetails.setAccountNumber(amount_Details.getAccountNumber());
		amountDetails.setType(amount_Details.getType());
		model.addAttribute("amountDetails", amountDetails);
		
		Optional<Client_Account> account = clientAccountRepo.findById(amountDetails.getAccountNumber());
		if(account.isPresent()) {
			balance = account.get().getDisplayBalance();
			if(balance > 0 && !(account.get().getAccountTypeCode().equalsIgnoreCase("CHQ"))) {
				balance = balance - amountDetails.getAmount();
			}
			else if (account.get().getAccountTypeCode().equalsIgnoreCase("CHQ") && balance < -10000) {
				balance = balance + amountDetails.getAmount();
			}else if (account.get().getAccountTypeCode().equalsIgnoreCase("CHQ") && balance > 0) {
				balance = balance - amountDetails.getAmount();
			}else if (balance == 0)
				return "<h2>Insufficient funds on Account number " + account.get().getClientAccountNumber() + "</h2>";
			
			account.get().setDisplayBalance(balance);
		} 
		
		clientAccountRepo.save(account.get());
		
		return "amount-withdrawn";
		
	}

}
