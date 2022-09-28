package com.example.thuggeelya;

import com.example.thuggeelya.repositories.User;
import com.example.thuggeelya.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner runner (UserRepository ur) {
        return args -> {
            Arrays.asList("rodd@mail.ru,sayer@yandex.ru,jurgen@cloud.com,ALLTHECOMMUNITY@MOSCOW.UA,play@bibi.theme".split(","))
                    .forEach(x -> ur.save(new User(x)));
            ur.findAll().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
