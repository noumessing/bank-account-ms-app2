package com.noumess.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.noumess.customerservice.entities.Customer;
import com.noumess.customerservice.repository.CustomerRepository;
import com.noumess.customerservice.config.GlobalConfig;



@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerService2Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerService2Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				
			}
		};
		
		return args -> {
			Customer customer1 = Customer.builder()
					.firstName("Hassan")
					.lastName("Elhouni")
					.email("hassan@gmail.com")
					.build();
			customerRepository.save(customer1);
			Customer customer2 = Customer.builder()
					.firstName("Mohamed")
					.lastName("Elhanouni")
					.email("mohamed@gmail.com")
					.build();
			customerRepository.save(customer2);
			
		};
	}
	
	

}
