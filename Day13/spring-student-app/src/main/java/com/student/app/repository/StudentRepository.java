package com.student.app.repository;

import com.student.app.model.Student;
import com.student.app.model.StudentData;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentData, Integer> {
}
