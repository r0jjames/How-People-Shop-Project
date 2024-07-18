package com.hps.customers_experience;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Customer Experiences and Insights API",
				version = "1.0",
				description = "API for retrieving customer experiences and insights",
				contact = @Contact(
						name = "Roj Carranza",
						url  = "",
						email = "rojjamescarranza@gmail.com"
				)
		)
)
public class CustomersExperienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersExperienceApplication.class, args);
	}

}
