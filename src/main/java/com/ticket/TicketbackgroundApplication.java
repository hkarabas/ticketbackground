package com.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bilet.controller.RestControllerDefault;

@SpringBootApplication
@ComponentScan({"com.bilet.controller","com.bilet.exception"})
@EntityScan("com.bilet.model")
@EnableJpaRepositories("com.bilet.repositories")
public class TicketbackgroundApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TicketbackgroundApplication.class, args);
		System.out.println("hewhwhwhw");
		
	}

}
