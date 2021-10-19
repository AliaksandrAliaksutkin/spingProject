package org.example.model;
import lombok.*;
import javax.persistence.*;                                 //для связи с БД
@NoArgsConstructor                                          // конструктор без аргументов (одно из требований соответствия Entity);
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
@Entity                                                     // Объект персистентной сущности. Как правило представляет таблицу в реляционной БД;
public class User {
    @Id                                                     // Определяет простой первичный ключ, состоящий из одного поля;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)     //автоматическая генерация значения первичного ключа
    @Column(name = "id_user")
    private int id; //здесь лучше Long
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;

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
