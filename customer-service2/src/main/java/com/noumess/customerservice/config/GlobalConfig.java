package com.noumess.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig {
	
	private int p1;
	private int p2;

}
