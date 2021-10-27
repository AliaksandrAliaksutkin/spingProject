package org.example.service;

import java.util.List;

import org.example.exception.NoEntityException;
import org.example.model.User;

public interface UserService {
    User save (User user);

    List<User> listAll();
//
//    User getById(Long id) throws NoEntityException;
//
//    void deleteById(Long id);
//
//    void deleteAll();
//
//    User editUser(User user);


}

