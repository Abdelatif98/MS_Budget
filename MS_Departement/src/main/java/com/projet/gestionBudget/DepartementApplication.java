package com.projet.gestionBudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartementApplication.class, args);
	}

}
