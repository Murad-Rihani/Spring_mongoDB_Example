package edu.projects.firstProject.students.shared.repositoryDAO;

import edu.projects.firstProject.students.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Students, String> {
    public Students findStudentByEmail(String email);
}
