package org.example.service;
import org.example.model.User;
import org.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import org.springframework.stereotype.Service;

import java.util.List;


@Log
@RequiredArgsConstructor
@Service
public class UserServiceImpl<log> implements UserService {
    private final UserRepository userRepository;

    @Override
    public void addUser(User user) {

        log.info("add User carried out successfully");
    }

    @Override
    public void removeUser(Integer id) {

    }

    @Override

    public User selectUser (Integer id) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public void removeAll() {

        log.info("Remove all users carried out successfully");
    }
}

