package com.example.hospital_managemant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class HospitalManagemantApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagemantApplication.class, args);
    }
    @Bean
            public WebMvcConfigurer configure() {
return new WebMvcConfigurer() {
@Override
public void addCorsMappings(CorsRegistry reg) {
reg.addMapping("/**").allowedOrigins("*");
}
};

}
}
