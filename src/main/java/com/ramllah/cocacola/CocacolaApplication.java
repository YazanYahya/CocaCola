package com.ramllah.cocacola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.ramllah.cocacola.application.user","com.ramllah.cocacola.application.product"})
public class CocacolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocacolaApplication.class, args);
    }
}
