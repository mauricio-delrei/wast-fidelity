package com.wasp.fidelity.church_secretaria_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChurchSecretariaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChurchSecretariaServiceApplication.class, args);
	}

}
