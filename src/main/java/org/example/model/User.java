package org.example.model;
import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String lastName;
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
