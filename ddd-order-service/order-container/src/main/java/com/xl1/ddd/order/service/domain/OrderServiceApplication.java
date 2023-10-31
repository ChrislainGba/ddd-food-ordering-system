package com.xl1.ddd.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.xl1.ddd.order.service.dataaccess", "com.xl1.ddd.dataaccess" })
@EntityScan(basePackages = { "com.xl1.ddd.order.service.dataaccess", "com.xl1.ddd.dataaccess"})
@ComponentScan("com.xl1.ddd") 
@SpringBootApplication(scanBasePackages = "com.xl1.ddd")
public class OrderServiceApplication {
    public static void main(String[] args) {
      SpringApplication.run(OrderServiceApplication.class, args);
    }
}

