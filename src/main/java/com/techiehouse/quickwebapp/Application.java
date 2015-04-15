package com.techiehouse.quickwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:/app-config.properties")
@ImportResource("classpath:/SpringContext.xml")
@EnableAutoConfiguration
@ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			
	}

}