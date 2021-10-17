package org.example.service;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Log
//@Transactional
/*говорит, что метод будет транзакционным.
Это значит, что вызов метода будет обернут в proxy объект, у которого будет сессия,
и при вызове всех вложенных методов эта сессия будет одна и та же,
и при завершении метода транзакция закроется.*/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    /*  Service – это Java класс, который предоставляет с себя основную (Бизнес-Логику).
    В основном сервис использует готовые DAO/Repositories или же другие сервисы,
    для того чтобы предоставить конечные данные для пользовательского интерфейса.
    */
//    @Autowired  /*это аннотация которая позволит Spring инициализировать наш сервис;*/
    private  final UserRepository userRepository;
    /*объявление нашего сервиса (обрати внимание, что это интерфейс,
    а не реализация), который позволит нам использовать его бизнес-логику;*/

    @Override
//    public void addUser(User user1) {
//        userRepository.save(user1);
//        log.info("Add user");
//    }
    public User addUser(User user1) {
        User saveUser = userRepository.saveAndFlush(user1);
        log.info("Add user");
        return saveUser;
    }
    /*тут мы сохраняем User в БД используя метод saveAndFlush,
    используя просто save() мы сохраняем запись но после вызова
    flush данные попадают в БД;*/

//    @Override
//    public void deletedById(Integer id) {
//        userRepository.delete(id);
//    }

//    @Override
//    public User getById(Integer Id) {
//        return userRepository.findById(Id);
//    }

//    @Override
//    public User editUser(User user1) {
//        return userRepository.saveAllAndFlush(user1);
//    }
    /*update можно сделать тем же методом что и сохранение,
    так как hibernate умный, и он проверит, есть ли запись в БД,
    которую мы хотим сохранить, если есть, то он ее обновит*/

//    @Override
//    public List<User> getAll() {                /*получаем все данные с БД, а именно всех юзеров.*/
//        return userRepository.findAll();
//    }

//    @Override
//    public void deletedAll() {
//    }
}

