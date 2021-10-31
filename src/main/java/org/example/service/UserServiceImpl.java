package org.example.service;

import lombok.AllArgsConstructor;
import org.example.exception.NoEntityException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {                   /*  Service – это Java класс, который предоставляет с себя основную (Бизнес-Логику). В основном сервис использует готовые DAO/Repositories или же другие сервисы, для того чтобы предоставить конечные данные для пользовательского интерфейса.*/

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) throws NoEntityException {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }
}

