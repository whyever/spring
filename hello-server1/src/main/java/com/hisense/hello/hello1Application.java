package com.hisense.hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class hello1Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(hello1Application.class).web(true).run(args);
    }

}
