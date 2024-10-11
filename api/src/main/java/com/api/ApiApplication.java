package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Spring Boot application.
 * This class serves as the entry point for the application.
 * 
 * <p>
 * The {@code @SpringBootApplication} annotation indicates that this is a Spring
 * Boot application.
 * The {@code main} method uses {@code SpringApplication.run} to launch the
 * application.
 * </p>
 */
@SpringBootApplication
public class ApiApplication {
	/**
	 * The entry point of the Spring Boot application.
	 *
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
