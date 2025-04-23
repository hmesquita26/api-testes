package com.testesapi.api_testes.controllers;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> buscarUsuario(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
