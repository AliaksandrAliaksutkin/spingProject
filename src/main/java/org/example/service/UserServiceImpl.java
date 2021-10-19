package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.exception.NoEntityException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Log
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {                   /*  Service – это Java класс, который предоставляет с себя основную (Бизнес-Логику). В основном сервис использует готовые DAO/Repositories или же другие сервисы, для того чтобы предоставить конечные данные для пользовательского интерфейса.*/
    private final UserRepository userRepository;                        /*объявление сервиса (обрати внимание, что это интерфейс,а не реализация), который позволит нам использовать его бизнес-логику;*/

    @Override
    public User addUser(User user) {
        User saveUser = userRepository.saveAndFlush(user);              /*  Тут мы сохраняем User в БД используя метод saveAndFlush, используя просто save() мы сохраняем запись но после вызова flush данные попадают в БД;*/
        log.info("user are added and saved in the table");
        return saveUser;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        log.info("User with id: " + id + " successfully deleted");
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
        log.info("All users have been successfully deleted from the table");
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) throws NoEntityException {
        return userRepository.findById(id).orElseThrow(() -> new NoEntityException("User with id: " + id + " not found"));
    }

    @Override
    public User editUser(User user) {
        User editUser = userRepository.saveAndFlush(user);
        return editUser;
    }

    @Override
    public List<User> getByLastName(String lastName) {
        return userRepository.findUsersByLastNameContainingIgnoreCase("Ivanov");
    }

}

