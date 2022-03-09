package edu.projects.firstProject.students.shared.services;

import edu.projects.firstProject.students.model.Students;
import edu.projects.firstProject.students.shared.repositoryDAO.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * @return all students information
     */
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * @param email
     * @return
     */
    public Students getStudentByEmail(String email) throws InstanceNotFoundException {
        Students student = fetchStudentByEmail(email);

        if (student == null){
            throw new InstanceNotFoundException(String.format("student with E-mail: %s is Not Found!", email));
        }

        return student;
    }

    /**
     * @param newStudent
     * @return
     */
    public String insertStudent(Students newStudent){
        if (newStudent.getEmail() == null){
        return "E-mail field is required";
        }

        Students student = fetchStudentByEmail(newStudent.getEmail());
        if ( student != null){
            return "Student is already Exists";
        }

        newStudent.setCreationDate(LocalDateTime.now());
        studentRepository.save(newStudent);
        return "Student Inserted";
    }

    /**
     * @return
     */
    public String deleteAllStudents() {
        studentRepository.deleteAll();
        return "All Students have been deleted";
    }

    /**
     * @param email
     * @return
     */
    public String deleteStudentByEmail(String email){
        Students student = fetchStudentByEmail(email);
        if ( student == null){
            return "Student is Not Exists";
        }

        studentRepository.delete(student);
        return "Student deleted";
    }

    /**
     * @param email
     * @param newStudentInfo
     * @return
     */
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

    /**
     * @param email
     * @return
     */
    private Students fetchStudentByEmail(String email){
        return studentRepository.findStudentByEmail(email);
    }
}
