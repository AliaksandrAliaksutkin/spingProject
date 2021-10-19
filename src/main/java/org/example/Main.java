package org.example;

import org.example.config.JPAConfig;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);   /*в качестве аргумента к передается класс, либо список классов с аннотацией @Configuration, либо с любой другой аннотацией JSR-330, в том числе и @Component*/
        User user1 = new User("Alex", "Utkin", 33);
        User user2 = new User("Ivan", "Ivanov", 35);
        User user3 = new User("Petr", "Ivanov", 37);
        User user4 = new User("Vasilii", "Vasiliev", 34);


        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);                /*Метод getBean() может принимать в качестве аргумента как класс(как показано выше), так и названия бина, либо другие варианты. Однако такой подход не рекомендуется использовать в production-конфигурациях, т.к. для подобных целей существует механизм Dependency Injection (DI).*/
        userServiceImpl.addUser(user1);
        userServiceImpl.addUser(user2);
        userServiceImpl.addUser(user3);
        userServiceImpl.addUser(user4);

        User user = new User(4,"Yakut", "Yakutov", 55);
        userServiceImpl.editUser(user);

        userServiceImpl.deleteById(1);
        System.out.println("-----------------------------------------------------");
        User searchedUser = userServiceImpl.getById(3);
        System.out.println(searchedUser);
        System.out.println("-----------------------------------------------------");
        List<User> userListGetLastName= userServiceImpl.getByLastName("Ivanov");
        System.out.println(userListGetLastName);
        System.out.println("-----------------------------------------------------");
        List<User> userList = userServiceImpl.getAll();
        userList.forEach(System.out::println);

//        userServiceImpl.deleteAll();
    }
}


