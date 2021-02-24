package com.mycompany.invoise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class InvoiseWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiseWebApplication.class, args);
	}

}
