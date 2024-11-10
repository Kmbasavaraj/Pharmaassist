package com.jsp.pharma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ApplicationDoc {
	
	Info info() {
		return new Info().title("Pharmacy Management System")
						 .description("Pharmacy Management System is a Restful WebService Built "
						 		+ "using Spring Boot, This API Covers "
						 		+ "All Crud operations ")
						 .version("v1").contact(contact());
	}
	
	Contact contact() {
		return new Contact()
					.name("Basavaraj K M")
					.url("Bais.com")
					.email("basi@gmail.com");
	}
	
	@Bean
	OpenAPI openApi() {
		return new OpenAPI().info(info());
	}

}
