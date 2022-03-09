package edu.projects.firstProject.students.model;

import edu.projects.firstProject.students.shared.Address;
import edu.projects.firstProject.students.shared.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Students {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int phoneNumber;
    @Indexed(unique = true)
    private String email;
    private Address address;
    List<String> books;
    private LocalDateTime creationDate;

    public Students(){

    }

    public Students(String firstName, String lastName, Gender gender, int phoneNumber, String email,
                    Address address, List<String> books, LocalDateTime creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.books = books;
        this.creationDate = creationDate;
    }
}
