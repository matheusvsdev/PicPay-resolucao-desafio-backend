package com.matheusvsdev.picpay_challenge_resolution.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Desafio Back-end PicPay")
                        .version("1.0")
                        .description("Habilidades básicas de criação de projetos backend:\n" +
                                "\n" +
                                "Conhecimentos sobre REST\n" +
                                "Uso do Git\n" +
                                "Capacidade analítica\n" +
                                "Apresentação de código limpo e organizado\n" +
                                "Conhecimentos intermediários de construção de projetos manuteníveis:\n" +
                                "\n" +
                                "Aderência a recomendações de implementação como as PSRs\n" +
                                "Aplicação e conhecimentos de SOLID\n" +
                                "Identificação e aplicação de Design Patterns\n" +
                                "Noções de funcionamento e uso de Cache\n" +
                                "Conhecimentos sobre conceitos de containers (Docker, Podman etc)\n" +
                                "Documentação e descrição de funcionalidades e manuseio do projeto\n" +
                                "Implementação e conhecimentos sobre testes de unidade e integração\n" +
                                "Identificar e propor melhorias\n" +
                                "Boas noções de bancos de dados relacionais\n" +
                                "Aptidões para criar e manter aplicações de alta qualidade:\n" +
                                "\n" +
                                "Aplicação de conhecimentos de observabilidade\n" +
                                "Utlização de CI para rodar testes e análises estáticas\n" +
                                "Conhecimentos sobre bancos de dados não-relacionais\n" +
                                "Aplicação de arquiteturas (CQRS, Event-sourcing, Microsserviços, Monolito modular)\n" +
                                "Uso e implementação de mensageria\n" +
                                "Noções de escalabilidade\n" +
                                "Boas habilidades na aplicação do conhecimento do negócio no software\n" +
                                "Implementação margeada por ferramentas de qualidade (análise estática, PHPMD, PHPStan, PHP-CS-Fixer etc)\n" +
                                "Noções de PHP assíncrono")
                        .termsOfService("https://example.com/terms")
                        .contact(new Contact()
                                .name("Matheus Valdevino")
                                .email("matheusvaldevino1997@gmail.com")
                                .url("https://yourwebsite.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
