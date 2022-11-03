package ru.netology.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo.repository.UserRepository;
import ru.netology.springbootdemo.sevice.AuthorizationService;

@Configuration
public class AppConfig {

    @Bean
    public AuthorizationService authorizationService() {
        return new AuthorizationService();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}