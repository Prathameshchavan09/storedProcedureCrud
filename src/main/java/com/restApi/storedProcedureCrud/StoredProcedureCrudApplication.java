package com.restApi.storedProcedureCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restApi.storedProcedureCrud.controller","com.restApi.storedProcedureCrud.dao","com.restApi.storedProcedureCrud.model","com.restApi.storedProcedureCrud.service"})

public class StoredProcedureCrudApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(StoredProcedureCrudApplication.class, args);
		System.out.println("fdfdf");
	}

}	
