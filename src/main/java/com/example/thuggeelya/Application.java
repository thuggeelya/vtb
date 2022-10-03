package com.example.thuggeelya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

//    @Bean
//    CommandLineRunner runner (UserRepository ur) {
//        return args -> {
//            Arrays.asList("rodd@mail.ru,sayer@yandex.ru,jurgen@cloud.com,ALLTHECOMMUNITY@MOSCOW.UA,play@bibi.theme".split(","))
//                    .forEach(x -> ur.save(new User(x)));
//            ur.findAll().forEach(System.out::println);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
