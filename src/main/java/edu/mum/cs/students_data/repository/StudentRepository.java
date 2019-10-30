package edu.mum.cs.students_data.repository;

import edu.mum.cs.students_data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
