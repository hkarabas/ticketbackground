package com.ticket;

import com.bilet.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
@ComponentScan({"com.bilet.controller","com.bilet.exception"})
@EntityScan("com.bilet.model")
@EnableJpaRepositories("com.bilet.repositories")
@Slf4j
public class TicketbackgroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketbackgroundApplication.class, args);
		log.debug("Application Start");

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Configuration
	@EnableJpaAuditing
	class DataJpaConfig {
		@Bean
		public AuditorAware<User> auditor() {
			return () -> Optional.ofNullable(SecurityContextHolder.getContext())
					.map(SecurityContext::getAuthentication)
					.filter(Authentication::isAuthenticated)
					.map(Authentication::getPrincipal)
					.map(User.class::cast);
		}
	}
}

