package com.hisense.sql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@EnableAutoConfiguration
@Configuration
@ComponentScan//允许跨域访问
@MapperScan("com.hisense")
@SpringBootApplication()
public class sqlApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(sqlApplication.class,args);
    }
}
