package com.homework.homework_with_likelion_w2_2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HomeworkWithLikelionW22Application {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkWithLikelionW22Application.class, args);
    }
    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
