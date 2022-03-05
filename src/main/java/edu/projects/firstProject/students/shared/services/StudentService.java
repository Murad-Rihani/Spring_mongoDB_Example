package edu.projects.firstProject.students.shared.services;

import edu.projects.firstProject.students.model.Students;
import edu.projects.firstProject.students.shared.repositoryDAO.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    public String insertStudent(Students newStudent){
        Students student = fetchStudentByEmail(newStudent.getEmail());
        if ( student != null){
            return "Student is already Exists";
        }

        newStudent.setCreationDate(LocalDateTime.now());
        studentRepository.save(newStudent);
        return "Student Inserted";
    }

    public String deleteStudentByEmail(String email){
        Students student = fetchStudentByEmail(email);
        if ( student == null){
            return "Student is Not Exists";
        }

        studentRepository.delete(student);
        return "Student deleted";
    }

    public String updateStudentByEmail(String email, Students newStudentInfo) {
        Students student = fetchStudentByEmail(email);
        if ( student == null){
            return "Sorry, Student is Not Exists";
        }

        newStudentInfo.setId(student.getId());
        newStudentInfo.setCreationDate(student.getCreationDate());
        studentRepository.save(newStudentInfo);
        return "Student updated";
    }

    private Students fetchStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);
    }
}
