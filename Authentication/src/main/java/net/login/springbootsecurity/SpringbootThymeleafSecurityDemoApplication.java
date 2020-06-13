package net.login.springbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootThymeleafSecurityDemoApplication
{

	public static void main(String[] args) {

		SpringApplication.run(SpringbootThymeleafSecurityDemoApplication.class, args);

	}

}
