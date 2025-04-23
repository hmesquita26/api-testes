package com.testesapi.api_testes.services.impl;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.repositories.UserRepository;
import com.testesapi.api_testes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> objUser = repository.findById(id);
        return objUser.orElse(null);
    }
}
