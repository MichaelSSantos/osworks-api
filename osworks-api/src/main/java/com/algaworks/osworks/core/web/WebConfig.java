package com.algaworks.osworks.core.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de customização do Spring MVC.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Configuração da política de CORS para que navegadores consigam acessar 
	 * a API diretamente pelo JavaScript e evitar o preflight.
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")//Permite qualquer origin
//			.allowedOrigins("*")//Este já é o padrão.
			.allowedHeaders("*");//Permite todos os métodos
	}
	
}
