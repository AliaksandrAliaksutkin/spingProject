package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select b from User b where b.lastName = :lastName")
    User findByLastName(@Param("lastName") String lastName);

    /*      JpaRepository – это интерфейс фреймворка Spring Data предоставляющий
        набор стандартных методов JPA для работы с БД.
            На основе этого интерфейса Spring Data предоставит реализации с методами,
        которые мы используем в Entity Manager.

            Для создания Repository нужно придерживаться нескольких правил:
        1 – Имя репозитория должно начинаться с имени сущности NameReposytory (необязательно).
        2 – Второй Generic должен быть оберточным типом того типа которым есть ID нашей сущности (обязательно).
        3 – Первый Generic должен быть объектом нашей сущности для которой мы создали Repository, это указывает на то,
            что Spring Data должен предоставить реализацию методов для работы с этой сущностью (обязательно).
        4 – Мы должны унаследовать свой интерфейс от JpaRepository,
            иначе Spring Data не предоставит реализацию для нашего репозитория (обязательно).
    */
}
