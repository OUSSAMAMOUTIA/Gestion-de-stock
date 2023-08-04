package com.example.gestion_de_stock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gestion de stock ",version = "1.0.0"))
@EnableJpaAuditing
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "Bearer Authentication",bearerFormat = "JWT", scheme = "bearer")
public class GestioDeStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioDeStockApplication.class, args);
    }

}
