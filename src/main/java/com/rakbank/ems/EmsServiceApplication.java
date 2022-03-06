package com.rakbank.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsServiceApplication.class, args);
	}

}
