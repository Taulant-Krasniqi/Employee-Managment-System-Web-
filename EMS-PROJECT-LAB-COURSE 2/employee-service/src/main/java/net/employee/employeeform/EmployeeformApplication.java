package net.employee.employeeform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
@EnableEurekaClient
public class EmployeeformApplication {



	public static void main(String[] args) {
		SpringApplication.run(EmployeeformApplication.class, args);
	}

}
