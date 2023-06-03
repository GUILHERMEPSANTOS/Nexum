package com.nexum.backend;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyStore;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackendApplication {
	public static void main(String[] args) throws Exception {
		RestTemplate restTemplate = restTemplate();
		SpringApplication.run(BackendApplication.class, args);
	}

	private static RestTemplate restTemplate() throws Exception {
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
		trustStore.load(null, null);

		TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;

		SSLContext sslContext = SSLContextBuilder
				.create()
				.loadTrustMaterial(trustStore, acceptingTrustStrategy)
				.build();

		SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

		HttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(socketFactory)
				.build();

		HttpComponentsClientHttpRequestFactory factory =
				new HttpComponentsClientHttpRequestFactory(httpClient);

		return new RestTemplate(factory);
	}
}
