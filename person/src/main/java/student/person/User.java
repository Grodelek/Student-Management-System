package student.person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String gpa;
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
