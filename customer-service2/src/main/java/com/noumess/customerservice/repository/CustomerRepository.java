package com.noumess.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.noumess.customerservice.entities.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
