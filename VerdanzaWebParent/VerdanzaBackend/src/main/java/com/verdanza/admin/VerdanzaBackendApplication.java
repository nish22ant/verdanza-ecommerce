package com.verdanza.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.verdanza.common.entity"})
public class VerdanzaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerdanzaBackendApplication.class, args);
	}

}
