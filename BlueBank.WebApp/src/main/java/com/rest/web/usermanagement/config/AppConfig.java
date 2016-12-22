package com.rest.web.usermanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Classe com as configurações da aplicação, Beans e anotações par:
 * leitura de properties, definição dos pacotes para escanear as anotações e
 * Habilitando uma configuração inicial para um contexto Web para uso dos serviço REST 
 * 
 * @author emersonmuraro
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rest.web.usermanagement")
@PropertySource(value = {"classpath:configuration.properties"})
public class AppConfig{
	
	/*
     * Configurando o PropertySourcesPlaceHolderConfigurer Bean para que aceite a 
     * anotação @Value("{}").
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
