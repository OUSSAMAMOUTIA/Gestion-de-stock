package com.example.gestion_de_stock;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gestion de stock ",version = "1.0.0"))
public class GestioDeStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestioDeStockApplication.class, args);
    }

}
