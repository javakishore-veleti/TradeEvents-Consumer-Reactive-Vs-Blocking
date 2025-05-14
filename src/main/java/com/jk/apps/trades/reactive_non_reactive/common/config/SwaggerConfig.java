package com.jk.apps.trades.reactive_non_reactive.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Trade Events Consumer API")
                        .description("API documentation for both reactive and non-reactive trade processing")
                        .version("1.0.0"));
    }
}
