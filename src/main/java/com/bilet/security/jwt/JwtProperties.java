package com.bilet.security.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	private String secretKey = "FenerBahce";


	private long validityInMs = 3600000; // 1 saatlik
}
