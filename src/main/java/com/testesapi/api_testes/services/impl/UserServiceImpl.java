package com.testesapi.api_testes.services.impl;

import com.testesapi.api_testes.domain.User;
import com.testesapi.api_testes.domain.dto.UserDTO;
import com.testesapi.api_testes.repositories.UserRepository;
import com.testesapi.api_testes.services.UserService;
import com.testesapi.api_testes.services.exceptions.DataIntegratyViolationException;
import com.testesapi.api_testes.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> objUser = repository.findById(id);
        return objUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId()) ) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }
}
