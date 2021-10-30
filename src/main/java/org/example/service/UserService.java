package org.example.service;

import java.util.List;

import org.example.exception.NoEntityException;
import org.example.model.User;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    User getById(Long id) throws NoEntityException;

    void deleteById(Long id);

}

