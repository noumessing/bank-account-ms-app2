package com.noumess.accountservice;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.noumess.accountservice.clients.CustomerRestClient;
import com.noumess.accountservice.entities.BankAccount;
import com.noumess.accountservice.enums.AccounType;
import com.noumess.accountservice.repository.BankAccountRepository;

@SpringBootApplication
@EnableFeignClients
public class AccountService2Application {

	public static void main(String[] args) {
		SpringApplication.run(AccountService2Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository,CustomerRestClient customerRestClient) {
		
		/* new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
			}
		};*/
		
	return args ->{	
		customerRestClient.allCustomer().forEach(c ->{
			BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("EUR")
					.balance(Math.random()*98000)
					.type(AccounType.SAVING_ACCOUNT)
					.creatAt(LocalDate.now())
					.customerId(c.getId())
					.build();
			
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("EUR")
					.type(AccounType.CURRENT_ACCOUNT)
					.balance(Math.random()*12000)
					.creatAt(LocalDate.now())
					.customerId(c.getId())
					.build();
			accountRepository.save(bankAccount1);
			accountRepository.save(bankAccount2);
		});
	};
	
	}
	

	/*
	return args -> {
		BankAccount bankAccount1 = BankAccount.builder()
				.accountId(UUID.randomUUID().toString())
				.currency("EUR")
				.balance(98000)
				.type(AccounType.SAVING_ACCOUNT)
				.creatAt(LocalDate.now())
				.customerId(Long.valueOf(1))
				.build();
		BankAccount bankAccount2 = BankAccount.builder()
				.accountId(UUID.randomUUID().toString())
				.currency("EUR")
				.type(AccounType.CURRENT_ACCOUNT)
				.balance(120000)
				.creatAt(LocalDate.now())
				.customerId(Long.valueOf(2))
				.build();
		
		accountRepository.save(bankAccount1);
		accountRepository.save(bankAccount2);
		
	};*/
}
