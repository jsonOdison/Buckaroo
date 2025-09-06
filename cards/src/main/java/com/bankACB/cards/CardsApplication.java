package com.bankACB.cards;

import com.bankACB.cards.dto.CardContactInfoDto;
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
@EnableConfigurationProperties(value = {CardContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "Buckaroo Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Jason Khongwir",
						email = "jasonkhongwir1738@gmail.com",
						url = "https://www.buckaroo.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.buckaroo.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Buckaroo Cards microservice REST API Documentation",
				url = "https://www.buckaroo.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
