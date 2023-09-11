package dev.clarke.rest.repository;

import dev.clarke.rest.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
