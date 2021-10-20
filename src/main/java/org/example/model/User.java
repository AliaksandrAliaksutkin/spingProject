package org.example.model;

import lombok.*;

import javax.persistence.*;                                 //для связи с БД

@NoArgsConstructor
// конструктор без аргументов (одно из требований соответствия Entity);
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
@Entity
// Объект персистентной сущности. Как правило представляет таблицу в реляционной БД;
public class User {
    @Id
    // Определяет простой первичный ключ, состоящий из одного поля;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)     //автоматическая генерация значения первичного ключа
    @Column(name = "id_user")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address_user")
    private Address address;

//    public User(String firstName, String lastName, int age) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    public User(Long id, String firstName, String lastName, int age) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//    }
//
//    public User(Long id, String firstName, String lastName, int age, Address address) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.address = address;
//    }

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
