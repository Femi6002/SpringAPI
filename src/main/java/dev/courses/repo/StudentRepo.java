package dev.courses.repo;

import dev.courses.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo  extends MongoRepository<Student, Integer> {

}
