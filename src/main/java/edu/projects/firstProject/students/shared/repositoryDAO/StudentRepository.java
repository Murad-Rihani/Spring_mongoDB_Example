package edu.projects.firstProject.students.shared.repositoryDAO;

import edu.projects.firstProject.students.model.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Students, String> {
    /**
     * @param email
     * @return student object if found in the DB
     */
     Students findStudentByEmail(String email);
}
