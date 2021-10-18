package org.example.service;

import java.util.List;

import org.example.model.User;

public interface UserService {
    User addUser(User user);

    void deleteById(Integer id);

    List<User> getAll();

    User getById(Integer id);

    User getByLastName(String lastName);

//    User editUser(User user);

    void deleteAll();

}

