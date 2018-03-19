package feign;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients		//加上@EnableFeignClients注解开启Feign的功能
@EnableDiscoveryClient
@SpringBootApplication
public class HelloFeignApp {

	public static void main(String[] args) {

		new SpringApplicationBuilder(HelloFeignApp.class).web(true).run(args);
	}

}
