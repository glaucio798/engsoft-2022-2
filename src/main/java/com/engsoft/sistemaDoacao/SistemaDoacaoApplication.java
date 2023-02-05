package com.engsoft.sistemaDoacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@EnableWebMvc
public class SistemaDoacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaDoacaoApplication.class, args);
	}

}
