package student.person;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String surname;
    private String phoneNumber;
    private String gpa;

    public Student(String name, String surname, String phoneNumber, String gpa) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.gpa = gpa;
    }

    public Student() {
    }
}
