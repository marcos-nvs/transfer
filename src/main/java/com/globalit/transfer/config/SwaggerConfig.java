package com.globalit.transfer.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Serviço de Transferência")
                        .description("Documentação da API de Agendamento de Transferência")
                        .version("Vi")
                );
    }
}
