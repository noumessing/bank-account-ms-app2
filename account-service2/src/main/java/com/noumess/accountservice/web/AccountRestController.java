package com.noumess.accountservice.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.noumess.accountservice.clients.CustomerRestClient;
import com.noumess.accountservice.entities.BankAccount;
import com.noumess.accountservice.model.Customer;
import com.noumess.accountservice.repository.BankAccountRepository;

@RestController
public class AccountRestController {
	
	private BankAccountRepository accountRepository;
	
	private CustomerRestClient customerRestClient;

	public AccountRestController(BankAccountRepository accountRepository,CustomerRestClient customerRestClient) {
				this.accountRepository = accountRepository;
				this.customerRestClient = customerRestClient;
		
		
		
	}
	
	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		return accountRepository.findAll().stream().map( a ->{
			Customer customer = customerRestClient.findCustomerById(a.getCustomerId());
			a.setCustomer(customer);
			return a;
			
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable String id) {
		BankAccount bankAccount = accountRepository.findById(id).get();
		Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
		bankAccount.setCustomer(customer);
	//	return accountRepository.findById(id).get();
		return bankAccount;
	}
	
	

}
