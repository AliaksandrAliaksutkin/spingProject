package org.example.service;

import java.util.List;
import org.example.model.User;

public interface UserService {
    void addUser(User user);

     void removeUser (Integer id);

    User selectUser (Integer id);

     List<User> listUsers();

     void removeAll();
}
