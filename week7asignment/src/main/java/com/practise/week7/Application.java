package com.practise.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

	ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		System.out.println(context.toString());

	}


}
