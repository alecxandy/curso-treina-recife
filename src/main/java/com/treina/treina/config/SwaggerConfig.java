package com.treina.treina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)//resposta padrao
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.treina.treina.controller"))//caminho do pacote da minhas APIs
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    //Informaçoes
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Java Experience API")
                .description("Api de sistema de gerenciamento de curso")
                .version("1.0")
                .contact(contact())
                .build();
    }

    //Contatos
    private Contact contact(){
        return new Contact("Alexandre Gomes"
                , "https://github.com/alecxandy",
                "alexandregsouza617@gmail.com");
    }

}
