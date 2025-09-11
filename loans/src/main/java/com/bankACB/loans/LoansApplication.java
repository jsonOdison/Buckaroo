package com.bankACB.loans;

import com.bankACB.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "Buckaroo Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Jason Khongwir",
						email = "jasonkhongwir1738@gmail.com",
						url = " "
				),
				license = @License(
						name = "Apache 2.0",
						url =  " "
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Buckaroo Loans microservice REST API Documentation",
				url = " "
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}
}
