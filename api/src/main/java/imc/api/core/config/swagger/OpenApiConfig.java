package imc.api.core.config.swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
  info = @Info(
    title = "IMC API",
    version = "1.0",
    description = "IMC API Documentation"
  )
)
public class OpenApiConfig { }
