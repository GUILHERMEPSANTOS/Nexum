package com.nexum.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class BackendApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(BackendApplication.class, args);
	}
}
