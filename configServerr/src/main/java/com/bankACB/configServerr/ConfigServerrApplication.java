package com.bankACB.configServerr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerrApplication.class, args);
	}

}
