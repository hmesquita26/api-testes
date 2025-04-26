package com.testesapi.api_testes.services;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
}
