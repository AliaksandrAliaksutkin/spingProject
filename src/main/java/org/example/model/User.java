package org.example.model;
import lombok.*;
import javax.persistence.*;
@NoArgsConstructor               // конструктор без аргументов (одно из требований соответствия Entity);
@AllArgsConstructor
@Setter
@Getter
@Entity (name = "users")         // Объект персистентной сущности. Как правило представляет таблицу в реляционной БД;
public class User {
    @Id                         // Определяет простой первичный ключ, состоящий из одного поля;
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //автоматическая генерация значения первичного ключа
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
