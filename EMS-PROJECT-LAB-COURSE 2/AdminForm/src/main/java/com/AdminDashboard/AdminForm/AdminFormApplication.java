package com.AdminDashboard.AdminForm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminFormApplication.class, args);
	}

}
