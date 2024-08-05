package com.rersdev.eduxpert.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIDocConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("EduXpert: API Restful")
                        .version("V1")
                        .description("It contains functionalities of EduXpert application")
                        .contact(new Contact()
                                .name("Rodys Rodriguez")
                                .email("rodisenrique73@gmail.com")
                                .url("https://github.com/rodys2003")));
    }
}
