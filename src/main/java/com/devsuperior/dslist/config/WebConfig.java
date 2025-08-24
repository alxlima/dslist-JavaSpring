//Classe que configuro o cors. origins. no aplication.properties. exemplo. url https://localhost:porta:7153 etc..
// por padr�o, se variavel de ambiente n�o existir na hospedagem. libero para o endere�o local hosto. se n�o para endere�o dominio. 
// caso configurar adicionoar variavel de ambiente [ CORS_ORIGINS:https//: nome.dominios] - isso libera o meu navegador, apenas para este dominio poder acessar.
package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Value("${cors.origins}")
	private String corsOrigins;

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}

}
