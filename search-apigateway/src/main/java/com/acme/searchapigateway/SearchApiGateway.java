package com.acme.searchapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@CrossOrigin
public class SearchApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(SearchApiGateway.class, args);
	}

}


@RestController
class SearchAPIGatewayController {

	@RequestMapping("/")
	String greet(HttpServletRequest req) {
		return "<H1>Search Gateway Powered by Zuul</H1>";
	}
}
