package com.testesapi.api_testes.controllers;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.domain.dto.UserDTO;
import com.testesapi.api_testes.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerTest {

    public static final Integer ID = 1;
    public static final String NAME = "Felipe";
    public static final String EMAIL = "felipe@email.com";
    public static final String PASSWORD = "54321";

    @InjectMocks
    private UserController controller;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void buscarPorId() {
    }

    @Test
    void buscarTodos() {
    }

    @Test
    void criar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void excluir() {
    }

    private void startUser() {
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
    }
}