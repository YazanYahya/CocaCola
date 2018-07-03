package edu.birzeit.cocacola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"edu.birzeit.cocacola.application.*"})
public class CocaColaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocaColaApplication.class, args);
    }
}
