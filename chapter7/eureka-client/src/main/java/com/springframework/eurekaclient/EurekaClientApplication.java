package com.springframework.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class EurekaClientApplication implements CommandLineRunner {

	@Autowired
	private SearchServiceClient serviceClient;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SearchQuery query = new SearchQuery("NYC", "SFO", "22-JAN-18");
		Flight[] flights = serviceClient.search(query);
		System.out.println(flights == null ? "0" : flights.length);
	}
}
