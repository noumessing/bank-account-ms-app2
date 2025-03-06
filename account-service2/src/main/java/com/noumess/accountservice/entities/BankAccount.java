package com.noumess.accountservice.entities;

import java.time.LocalDate;

import com.noumess.accountservice.enums.AccounType;
import com.noumess.accountservice.model.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
	@Id
	private String accountId;
	private double balance;
	private LocalDate creatAt;
	private String currency;
	@Enumerated(EnumType.STRING)
	private  AccounType type;
	@Transient
	private Customer customer;
	private Long customerId;
	

}
