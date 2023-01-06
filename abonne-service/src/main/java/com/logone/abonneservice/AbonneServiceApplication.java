package com.logone.abonneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AbonneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbonneServiceApplication.class, args);
	}

}
