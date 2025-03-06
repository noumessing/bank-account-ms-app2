package com.noumess.customerservice.web;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noumess.customerservice.entities.Customer;
import com.noumess.customerservice.repository.CustomerRepository;

@RestController
//@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerRepository customerRepository;

	public CustomerRestController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	@GetMapping("/customers")
	public List<Customer> customerList(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer customerById(@PathVariable Long id) {
		return customerRepository.findById(id).get();
	}
	
	
	
}
