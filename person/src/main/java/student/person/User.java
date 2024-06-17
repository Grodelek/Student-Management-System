package student.person;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OrderColumn(name = "name")
    private String name;
    @OrderColumn(name= "surname")
    private String surname;
    @OrderColumn(name = "gpa")
    private String gpa;
    @OrderColumn(name = "phone")
    private String phone;

    public User(Long id, String name, String surname, String gpa, String phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gpa = gpa;
        this.phone = phone;
    }

    public User() {
    }
}
