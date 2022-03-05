package edu.projects.firstProject.students.controller;

import edu.projects.firstProject.students.model.Students;
import edu.projects.firstProject.students.shared.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    StudentService studentService;

    @GetMapping
    public List<Students> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/insertStudent")
    public String insertStudent(@RequestBody Students newStudent ){
        return studentService.insertStudent(newStudent);
    }

    @DeleteMapping(path = "/{email}")
    public String deleteStudentByEmail(@PathVariable String email){
        return studentService.deleteStudentByEmail(email);
    }

    @PutMapping(path = "/{email}")
    public String updateStudent(@PathVariable String email, @RequestBody Students student){
        return studentService.updateStudentByEmail(email, student);
    }
}
