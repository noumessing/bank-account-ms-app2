package com.noumess.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noumess.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
