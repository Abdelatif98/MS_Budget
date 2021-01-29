package com.projet.gestionBudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BudgetCompteComptableApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetCompteComptableApplication.class, args);
	}

}
