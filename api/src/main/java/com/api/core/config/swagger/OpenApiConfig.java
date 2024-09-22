package com.api.core.config.swagger;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
/**
 * Configuration class for OpenAPI documentation.
 * 
 * This class sets up the OpenAPI definition for the com API, including
 * the title, version, and description of the API documentation.
 * 
 * Annotations:
 * - @Configuration: Indicates that this class is a configuration class.
 * - @OpenAPIDefinition: Provides metadata for the OpenAPI documentation.
 *   - @Info: Contains information about the API such as title, version, and description.
 *     - title: The title of the API documentation.
 *     - version: The version of the API.
 *     - description: A brief description of the API.
 */
@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "com API",
    version = "1.0",
    description = "com API Documentation"
  )
)
public class OpenApiConfig {}
