package com.noumess.accountservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.noumess.accountservice.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "CUSTOMER-SERVICE2")
public interface CustomerRestClient {
	
	@GetMapping("/customers/{id}")
	@CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
	Customer findCustomerById(@PathVariable Long id);
	
	@GetMapping("/customers")
	@CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomer")
	List<Customer> allCustomer();
	
	default Customer getDefaultCustomer(Long id, Exception exception) {
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstName("Not Avaible");
		customer.setLastName("Not Avaible");
		customer.setEmail("Not Avaible");
		
		return customer;
		
		
	}
	
	default List<Customer> getAllCustomer(Exception exception){
		
		return List.of();
	}

}
