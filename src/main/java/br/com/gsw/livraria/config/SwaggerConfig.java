package br.com.gsw.livraria.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("API para gerenciar os livros da livraria")
                        .description("Servicio para gerenciar e gerar relatorio do livros")
                        .version("0.0.1")
                );
    }
}