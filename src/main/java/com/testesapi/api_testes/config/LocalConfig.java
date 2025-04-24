package com.testesapi.api_testes.config;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void startDB(){
        User usuario1 = new User(null, "Felipe", "felipe@email.com", "12345");
        User usuario2 = new User(null, "Heytor", "heytor@email.com", "54321");

        repository.saveAll(List.of(usuario1, usuario2));
    }

}
