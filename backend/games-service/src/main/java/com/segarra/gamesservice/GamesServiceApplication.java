package com.segarra.gamesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaClient
public class GamesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamesServiceApplication.class, args);
	}

}
