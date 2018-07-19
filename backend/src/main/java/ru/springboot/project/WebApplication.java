package ru.springboot.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class WebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
            SpringApplication.run(WebApplication.class, args);
        }
}
