package net.login.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootThymeleafSecurityDemoApplication
{





	public static void main(String[] args) {

		SpringApplication.run(SpringbootThymeleafSecurityDemoApplication.class, args);

	}

}
