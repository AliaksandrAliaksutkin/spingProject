package org.example.service;

import org.example.exception.NoEntityException;
import org.example.model.User;
import org.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {                   /*  Service – это Java класс, который предоставляет с себя основную (Бизнес-Логику). В основном сервис использует готовые DAO/Repositories или же другие сервисы, для того чтобы предоставить конечные данные для пользовательского интерфейса.*/

    @Autowired
    private final UserRepository userRepository;                        /*объявление сервиса (обрати внимание, что это интерфейс,а не реализация), который позволит нам использовать его бизнес-логику;*/

    @Override
    public User save (User user) {
        return userRepository.saveAndFlush(user);                       /*  Тут мы сохраняем User в БД используя метод saveAndFlush, используя просто save() мы сохраняем запись но после вызова flush данные попадают в БД;*/
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        return userRepository.findAll();
    }

//    @Override
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//            }
//
//    @Override
//    public void deleteAll() {
//        userRepository.deleteAll();
//           }
//
//    @Override
//    @Transactional(readOnly = true)
//    public User getById(Long id) throws NoEntityException {
//        return userRepository.findById(id).orElseThrow(() -> new NoEntityException("User with id: " + id + " not found"));
//    }
//
//    @Override
//    public User editUser(User user) {
//        User editUser = userRepository.saveAndFlush(user);
//        return editUser;
//    }

    }

