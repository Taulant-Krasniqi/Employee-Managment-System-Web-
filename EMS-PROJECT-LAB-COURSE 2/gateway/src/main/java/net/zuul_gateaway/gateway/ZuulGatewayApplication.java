package net.zuul_gateaway.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}


	@Configuration
	class RestTemplateConfig {

		// Create a bean for restTemplate to call services
		@Bean
		@LoadBalanced        // Load balance between service instances running at different ports.
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}


	@Bean
	public ZuulFilter postFilter() {
		return new ZuulFilter() {

			@Override
			public boolean shouldFilter() {
				return true;
			}

			@Override
			public Object run() throws ZuulException {
				System.out.println("Pre Filter - run");
				HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
				System.out.println("Request Method : "+request.getMethod());
				System.out.println("Request URL : "+request.getRequestURL().toString());
				return null;
			}

			@Override
			public String filterType() {
				return "pre";
			}

			@Override
			public int filterOrder() {
				return 1;
			}
		};
	}
}

