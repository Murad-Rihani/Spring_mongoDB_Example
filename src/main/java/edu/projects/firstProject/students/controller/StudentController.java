package edu.projects.firstProject.students.controller;

import edu.projects.firstProject.students.model.Students;
import edu.projects.firstProject.students.shared.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping("/api/students") // This means URL's start with /api/students (after Application path)
@AllArgsConstructor //This annotation will define the constructor and handle the injection (Constructor-based dependency injection)
public class StudentController {

    private final StudentService studentService;

    /**
     * @return all students from student table
     */
    @GetMapping// Map ONLY GET Requests
    public List<Students> getAllStudents(){
        return studentService.getAllStudents();
    }

    /**
     * @param email
     * @return student information if found in the DB by email
     */
    @GetMapping(path = "/getStudent/{email}")// Map ONLY GET Requests
    public Students getStudentByEmail(@PathVariable String email){
        try {
            return studentService.getStudentByEmail(email);
        } catch (InstanceNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * @param newStudent information
     * @return insert response
     */
    @PostMapping("/insertStudent") // Map ONLY POST Requests
    public String insertStudent(@RequestBody Students newStudent ){
        return studentService.insertStudent(newStudent);
    }

    /**
     * @return delete all students response
     */
    @DeleteMapping(path = "/deleteStudent") // Map ONLY Delete Requests
    public String deleteAllStudent(){
        return studentService.deleteAllStudents();
    }

    /**
     * @param email
     * @return delete response
     */
    @DeleteMapping(path = "/deleteStudent/{email}") // Map ONLY Delete Requests
    public String deleteStudentByEmail(@PathVariable String email){
        return studentService.deleteStudentByEmail(email);
    }

    /**
     * @param email
     * @param student
     * @return update response
     */
    @PutMapping(path = "/updateStudent/{email}") // Map ONLY PUT Requests
    public String updateStudent(@PathVariable String email, @RequestBody Students student){
        return studentService.updateStudentByEmail(email, student);
    }
}
