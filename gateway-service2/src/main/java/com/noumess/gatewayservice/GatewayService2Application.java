package com.noumess.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayService2Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayService2Application.class, args);
	}
   
	@Bean  //configuration dynamique des routes
	DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
	
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	
	}
	
}
