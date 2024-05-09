package com.sb_webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sb_webapp")
public class WebApp{

    public static void main(String[] args){
        SpringApplication.run(WebApp.class, args);
    }

}
