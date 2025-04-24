package com.testesapi.api_testes.services;

import com.testesapi.api_testes.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
