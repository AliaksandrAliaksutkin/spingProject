package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.exception.NoEntityException;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
//todo не вижу транзакций, кроме методов чтения
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
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
        log.info("User with id: "+ id + " successfully deleted");
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
        log.info("All users have been successfully deleted from the table");
    }

    @Override
    @Transactional(readOnly = true)                                                 /*  говорит, что метод будет транзакционным. Это значит, что вызов метода будет обернут в proxy объект, у которого будет сессия,и при вызове всех вложенных методов эта сессия будет одна и та же,и при завершении метода транзакция закроется.*/
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Integer id) throws NoEntityException {
        return userRepository.findById(id).orElseThrow(()->new NoEntityException("User with id: "+ id +" not found"));
    }

    @Override
    public User getByLastName(String lastName) {
        return userRepository.findByLastName(lastName);                         /*используем аннотацию @Query которая позволяет создать SQL запрос, но этот запрос содержит параметр :lastName, его иы проставляем в структуре метода findByLastName() используя аннотаци. @Param в параметре которой мы указываем имя параметра запроса lastName.
                                                                                Spring Data на основе предоставленных данных в аннотациях сам предоставит реализацию этого метода, и это замечательно, так как теперь мы его можем использовать:*/
    }

    @Override
    public User editUser(User user) {
        User editUser = userRepository.saveAndFlush(user);
        return editUser;
    }
}

