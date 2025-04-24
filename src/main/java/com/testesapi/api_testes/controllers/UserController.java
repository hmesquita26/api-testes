package com.testesapi.api_testes.controllers;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.domain.dto.UserDTO;
import com.testesapi.api_testes.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> buscarUsuario(@PathVariable Integer id) {
        Optional<User> usuarioOpt = Optional.ofNullable(service.findById(id));
        if (usuarioOpt.isPresent()) {
            UserDTO dto = mapper.map(service.findById(id), UserDTO.class);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }
}
