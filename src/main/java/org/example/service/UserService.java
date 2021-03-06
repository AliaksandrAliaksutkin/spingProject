package org.example.service;

import java.util.List;

import org.example.model.User;

public interface UserService {
    User addUser(User user);

    void deleteById(Long id);

    List<User> getAll();

    User getById(Long id);

    void deleteAll();

    User editUser(User user);

    List<User> getByLastName(String lastName);
}

