package com.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The main class for the Spring Boot application.
 * This class serves as the entry point for the application.
 * 
 * <p>
 * It contains the main method which uses Spring Boot's SpringApplication.run()
 * method to launch the application.
 * </p>
 * 
 * <p>
 * Usage:
 * <pre>
 * {@code
 * java -jar api-application.jar
 * }
 * </pre>
 * </p>
 * 
 * <p>
 * Example:
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     SpringApplication.run(ApiApplication.class, args);
 * }
 * }
 * </pre>
 * </p>
 * 
 * @see org.springframework.boot.SpringApplication
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
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
