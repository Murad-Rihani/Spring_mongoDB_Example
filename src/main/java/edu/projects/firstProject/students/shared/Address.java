package edu.projects.firstProject.students.shared;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Serialization
@Data
@AllArgsConstructor
public class Address implements Serializable {
    private String country;
    private String city;
    private int postalCode;

}
